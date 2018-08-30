package org.aihdint.aihd.forms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.aihdint.aihd.Home;
import org.aihdint.aihd.common.Alerts;
import org.aihdint.aihd.common.File_Upload;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.common.Validation;
import org.aihdint.aihd.adapters.pages.DM_Initial_Adapter;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.fragments.initial.FragmentModelInitial;
import org.aihdint.aihd.model.Forms;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Developed by Rodney on 26/03/2018.
 */

public class DM_Initial extends AppCompatActivity implements FragmentModelInitial.FragStateChangeListener {

    //private static final String TAG = DM_Initial.class.getSimpleName();

    private JSONArray jsonArry1, jsonArry2, jsonArry3, jsonArry4, jsonArry5;
    private String encounter_date, file_name, form_id, patient_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_htn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        FragmentModelInitial.getInstance().setListener(this);

        Intent intent = getIntent();
        patient_id = intent.getStringExtra("patient_id");
        Log.d("PatientID", patient_id);

        file_name = "DM_HTN_INITIAL_" + System.currentTimeMillis() + ".json";
        form_id = System.currentTimeMillis() + "_" + patient_id;

        jsonArry1 = new JSONArray();
        jsonArry2 = new JSONArray();
        jsonArry3 = new JSONArray();
        jsonArry4 = new JSONArray();
        jsonArry5 = new JSONArray();

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_Initial_Adapter adapter = new DM_Initial_Adapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //noinspection deprecation
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public void initialOne(String encounterDate, JSONArray params) {
        encounter_date = encounterDate;
        jsonArry1 = params;
    }

    @Override
    public void initialTwo(JSONArray params) {
        jsonArry2 = params;
    }

    @Override
    public void initialThree(JSONArray params) {
        jsonArry3 = params;
    }

    @Override
    public void initialFour(JSONArray params) {
        jsonArry4 = params;
    }

    @Override
    public void initialFive(JSONArray params) {
        jsonArry5 = params;
    }

    public void validateInitial(View view) {

        ProgressDialog pDialog = File_Upload.showProgressDialog(this, "Uploading DM Initial Form ...");

        File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/initial");

        if (!dir.mkdirs()) {
            Log.e("Directory Message", "Directory not created");
        }


        File file = new File(dir, file_name);

        try {

            JSONArray jsonArray = JSONFormBuilder.concatArray(jsonArry1, jsonArry2, jsonArry3, jsonArry4, jsonArry5);
            JSONObject jsonForm = new JSONObject();

            String error = Validation.initialValidation(jsonArray);

            if (jsonArray.length() == 0) {
                error = "Please fill in required fields(*)";
            }

            if (error.length() == 0 && jsonArray.length() > 0) {
                String creator = AppController.getInstance().getSessionManager().getUserDetails().get("user_id");

                jsonForm.put("formDescription", "DM HTN Initial Encounter Form");
                jsonForm.put("formEncounterType", "bf3f3108-f87c-11e7-913d-5f679b8fdacb");
                jsonForm.put("formUuid", "7b0abbe2-98ab-4ba3-a423-e2441859f976");
                jsonForm.put("formVersion", "1.0");
                jsonForm.put("formUILocation", "patientDashboard.visitActions");
                jsonForm.put("formOrder", "1");
                jsonForm.put("encounterDate", encounter_date);
                jsonForm.put("encounterProvider", creator);
                jsonForm.put("location_id", AppController.getInstance().getSessionManager().getUserDetails().get("location_id"));
                jsonForm.put("patient_id", patient_id);
                jsonForm.put("obs", jsonArray);

                FileOutputStream f = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(f);
                pw.println(jsonForm.toString());
                pw.flush();
                pw.close();
                f.close();

                Forms forms = new Forms(form_id, file_name, creator, patient_id, "initial", encounter_date, "0");
                long id = forms.save();

                Toast.makeText(getBaseContext(), "Initial Encounter file saved", Toast.LENGTH_SHORT).show();

                boolean isConnected = File_Upload.connectivity(getApplicationContext());
                if (isConnected) {
                    File_Upload.upload(this, Environment.getExternalStorageDirectory() + "/aihd/initial/" + file_name, id, null);
                } else {
                    Toast.makeText(this, "No Internet Connection,Unable to upload file", Toast.LENGTH_SHORT).show();

                    // Launch login activity
                    Intent intent = new Intent(this, Home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            } else {
                Alerts.alert_msg(this, "Validation Error", error);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("Error", "*** File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
        } catch (Exception e) {
            e.printStackTrace();
        }


        pDialog.dismiss();
        //Log.d("JSON FollowUp", jsonObs1.toString() + " " + dir.toString());


    }


    /*
     * Method to make json array request where response starts with [
     *

    private void dmInitialForm() {

        // Tag used to cancel the request
        String tag_string_req = "req_upload";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                DMINITIAL_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Upload Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        Toast.makeText(getApplicationContext(), "Form successfully uploaded.!", Toast.LENGTH_LONG).show();
                    }

                    pDialog.dismiss();
                } catch (JSONException e) {
                    pDialog.dismiss();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Upload Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();

                params.put("uuid", AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                JSONObject jsonParams = new JSONObject(params);
                JSONObject jsonAdd = new JSONObject();

                try {
                    jsonAdd.put("Encounter", "85562bbn-jjk96");
                    jsonAdd.put("obs", jsonParams);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("Params", jsonAdd.toString());


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }


    /*
    public void validateInitial(View view) {
        //dmInitialForm();
        //File_Upload.
    }
    */
}
