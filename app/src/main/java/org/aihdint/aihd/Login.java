package org.aihdint.aihd;

/*
 * Developed by Rodney on 02/03/2018.
 */

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.orm.query.Select;

import org.aihdint.aihd.common.File_Upload;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Config;
import org.aihdint.aihd.app.SessionManager;
import org.aihdint.aihd.model.Concepts;
import org.aihdint.aihd.model.KeyValue;
import org.aihdint.aihd.model.Location;
import org.aihdint.aihd.services.LoadPatients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Login extends Activity {
    private static final String TAG = Login.class.getSimpleName();
    private EditText inputUsername;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private CoordinatorLayout coordinatorLayout;
    private String location_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        } else {
            checkPermissions();
            loadJSONLocation();
            loadJSONConcepts();
        }

    }


    public void setLocationData() {
        Spinner spinnerLocation = findViewById(R.id.spinnerLocationLogin);
        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add locations
        keyvalue.add(new KeyValue("", "Select Location"));

        List<Location> locations = Location.findWithQuery(Location.class, "SELECT * from LOCATION ORDER BY _name ASC ");
        for (Location ln : locations) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue(ln.getID(), ln.getName()));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //spinnerLocation.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                location_id = value.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void loadJSONConcepts() {

        String json;

        try {

            List<Concepts> concept_count = Select.from(Concepts.class).list();
            if (concept_count.size() > 0) {
                Concepts.deleteAll(Concepts.class);
            }

            InputStream is = getAssets().open("concepts.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject conceptObj = jsonArray.getJSONObject(i);

                String concept_id = conceptObj.getString("Concept ID");
                String concept = conceptObj.getString("Concept");

                Concepts concepts = new Concepts(concept_id, concept);
                concepts.save();

            }

            setLocationData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadJSONLocation() {

        String json;


        try {

            List<Location> location_count = Select.from(Location.class).list();
            if (location_count.size() > 0) {
                Location.deleteAll(Location.class);
            }

            InputStream is = getAssets().open("locations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject locationObj = jsonArray.getJSONObject(i);

                //String location_id = locationObj.getString("location_id");
                String mfl_code = String.valueOf(locationObj.getInt("MFL Code"));
                String name = locationObj.getString("Facility Name");
                String location_id = name;
                location_id = location_id.toLowerCase();
                location_id = location_id.replace(".", "");
                location_id = location_id.replace(" ", "_");
                Log.d("Location Name", location_id);

                Location location = new Location(location_id, name, mfl_code);
                location.save();

            }

            setLocationData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void login(View view) {

        String username = inputUsername.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        // Check for empty data in the form
        //&& !location_id.isEmpty()
        if (!username.isEmpty() && !password.isEmpty() && !location_id.isEmpty()) {
            // login user
            boolean isConnected = File_Upload.connectivity(getApplicationContext());

            if (isConnected) {
                loginServer(username, password);
            } else {
                Toast.makeText(this, "No Internet Connection,Unable to load locations", Toast.LENGTH_SHORT).show();
            }

        } else {
            // Prompt user to enter credentials
            Toast.makeText(getApplicationContext(),
                    "Please enter the credentials!", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * function to verify login details in mysql db
     */
    private void loginServer(final String username, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                Config.LOGIN_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response);
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    String authenticated = jObj.getString("authenticated");

                    // Check for error node in json
                    if (authenticated.matches("true")) {
                        // user successfully logged in

                        // Now store the user in SQLite
                        //String uuid = jObj.getString("uid");
                        Intent grapprIntent = new Intent(getApplicationContext(), LoadPatients.class);
                        getApplication().startService(grapprIntent);

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("display");
                        String user_id = user.getString("uuid");

                        //JSONObject person = user.getJSONObject("person");

                        List<Location> location = Location.findWithQuery(Location.class, "SELECT * from LOCATION WHERE _id = ? LIMIT 1", location_id);

                        // Create login session
                        session.setLogin(true);
                        session.createLogin(user_id, name, password, location_id, location.get(0).get_mfl_code());

                        // Launch main activity
                        Intent intent = new Intent(Login.this,
                                Home.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        Toast.makeText(getApplicationContext(),
                                "Username/Password Invalid", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                String credentials = username + ":" + password;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                // since we don't know which of the two underlying network vehicles
                // will Volley use, we have to handle and store session cookies manually
                Log.i("response", response.headers.toString());
                Map<String, String> responseHeaders = response.headers;
                String rawCookies = responseHeaders.get("Set-Cookie");
                Log.i("cookies", rawCookies);
                return super.parseNetworkResponse(response);
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            List<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), 101);
            }

            //return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 101: {
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        Log.d("Permissions", "Permission Granted: " + permissions[i]);

                    } else if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        Log.d("Permissions", "Permission Denied: " + permissions[i]);
                        //Toast.makeText(getActivity(), "LoyaltyClub won't work well unless you allow requested permissions to be granted", Toast.LENGTH_LONG).show();
                        Snackbar snackbar = Snackbar.make(coordinatorLayout, permissions[i] + " : Permission Denied", Snackbar.LENGTH_INDEFINITE);
                        snackbar.show();
                    }
                }
            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }


}