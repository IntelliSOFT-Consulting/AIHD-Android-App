package org.aihdint.aihd.patient;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.KeyValue;
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.services.LoadPatients;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.decode;
import static java.lang.Integer.parseInt;
import static org.aihdint.aihd.app.Config.PATIENT_REGISTER_URL;

/**
 * Developed by Rodney on 19/03/2018.
 */

public class Register extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = Register.class.getSimpleName();

    private String gender, birthdate, isEstimated, location_id, patient_type;
    private TextView textViewDOB;
    private Button buttonDOB;
    private EditText editTextAge, editTextFamilyName, editTextGivenName, editTextTelephone, editTextTelephoneOther, editTextPatientNumber;
    private EditText editTextAddress1, editTextAddress2, editTextAddress3, editTextCounty, editTextVillage;
    private EditText editTextSupporter, editTextSupporterNumber, editTextSupporterNumberOther, editTextSupporterAddress;
    private LinearLayout linearLayoutDOB, linearLayoutAge;

    private ProgressDialog pDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gender = birthdate = isEstimated = location_id = patient_type = "";
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        buttonDOB = findViewById(R.id.birthdate_button);

        editTextFamilyName = findViewById(R.id.family_name);
        editTextGivenName = findViewById(R.id.given_name);
        editTextTelephone = findViewById(R.id.telephone);
        editTextTelephoneOther = findViewById(R.id.telephone_other);
        editTextPatientNumber = findViewById(R.id.patient_number);

        editTextAddress1 = findViewById(R.id.address1);
        editTextAddress2 = findViewById(R.id.address2);
        editTextAddress3 = findViewById(R.id.address3);
        editTextCounty = findViewById(R.id.county_district);
        editTextVillage = findViewById(R.id.city_village);

        textViewDOB = findViewById(R.id.birthdate_textview);
        editTextAge = findViewById(R.id.age);

        editTextSupporter = findViewById(R.id.supporter_name);
        editTextSupporterAddress = findViewById(R.id.supporter_address);
        editTextSupporterNumber = findViewById(R.id.supporter_telephone);
        editTextSupporterNumberOther = findViewById(R.id.supporter_telephone_other);

        linearLayoutAge = findViewById(R.id.layout_age);
        linearLayoutDOB = findViewById(R.id.layout_dob);
        isEstimated = "0";

        editTextPatientNumber.setText(String.format("%s-", AppController.getInstance().getSessionManager().getUserDetails().get("mfl_code")));

        Spinner spinnerLocation = findViewById(R.id.spinnerLocation);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add locations
        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue("", "Select Location"));
        keyvalue.add(new KeyValue("1", "OutPatient Clinic"));
        keyvalue.add(new KeyValue("2", "Maternity"));
        keyvalue.add(new KeyValue("3", "C.C.C"));
        keyvalue.add(new KeyValue("4", "Inpatient"));
        keyvalue.add(new KeyValue("5", "Family Planning"));
        keyvalue.add(new KeyValue("6", "Casuality"));
        keyvalue.add(new KeyValue("7", "TB"));
        keyvalue.add(new KeyValue("8", "ANC"));


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
                //Toast.makeText(mContext, "ID: "+value.getId()+", Name : "+value.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void dob(View view) {

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                Register.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.showYearPickerFirst(true);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = year + "-" + monthOfYear + "-" + dayOfMonth;
        textViewDOB.setText(date);
        buttonDOB.setText(date);
        birthdate = date;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_male:
                if (checked)
                    gender = "M";
                break;
            case R.id.radio_female:
                if (checked)
                    gender = "F";
                break;
            case R.id.birthdate_estimated_yes:
                if (checked) {
                    isEstimated = "1";
                }
                linearLayoutAge.setVisibility(View.VISIBLE);
                linearLayoutDOB.setVisibility(View.GONE);
                break;
            case R.id.birthdate_estimated_no:
                if (checked)
                    isEstimated = "0";
                linearLayoutDOB.setVisibility(View.VISIBLE);
                linearLayoutAge.setVisibility(View.GONE);
                break;
            case R.id.radio_new_patient:
                if (checked)
                    patient_type = "new";
                break;
            case R.id.radio_patient_in_transit:
                if (checked)
                    patient_type = "patient_in_transit";
                break;
            default:
                break;
        }
    }


    public void validation() {
        String family_name = editTextFamilyName.getText().toString().trim();
        String given_name = editTextGivenName.getText().toString().trim();
        String telephone = editTextTelephone.getText().toString().trim();
        String telephone_other = editTextTelephoneOther.getText().toString().trim();
        String patient_number = editTextPatientNumber.getText().toString().trim();
        String address1 = editTextAddress1.getText().toString().trim();
        String address2 = editTextAddress2.getText().toString().trim();
        String address3 = editTextAddress3.getText().toString().trim();
        String county_district = editTextCounty.getText().toString().trim();
        String city_village = editTextVillage.getText().toString().trim();
        String supporter = editTextSupporter.getText().toString().trim();
        String supporter_address = editTextSupporterAddress.getText().toString().trim();
        String supporter_number = editTextSupporterNumber.getText().toString().trim();
        String supporter_number_other = editTextSupporterNumberOther.getText().toString().trim();

        //birthdate;
        if (!editTextAge.getText().toString().matches("") && parseInt(editTextAge.getText().toString()) > 0) {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat year = new SimpleDateFormat("yyyy");
            int birth_year = parseInt(year.format(new Date())) - parseInt(editTextAge.getText().toString().trim());

            @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("-MM-dd HH:mm:ss");

            birthdate = birth_year + dateFormat.format(new Date());
        }

        // Check for empty data in the form
        if (!family_name.isEmpty()
                && !given_name.isEmpty()
                && !gender.isEmpty()
                && !telephone.isEmpty()
                && !patient_number.isEmpty()
                && !birthdate.isEmpty()
                ) {

            pDialog.setMessage("Registering patient...");
            showDialog();

            // Inserting row in users table
            new Person(family_name, given_name, gender, birthdate, isEstimated, telephone, patient_number, location_id, address1, address2, address3, county_district, city_village, supporter, supporter_address, supporter_number, "0");

            ConnectivityManager cm =
                    (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

            assert cm != null;
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();

            if (isConnected) {
                registerPatient(family_name, given_name, telephone, telephone_other, patient_number, address1, address2, address3, county_district, city_village, supporter, supporter_address, supporter_number, supporter_number_other);
            } else {
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", given_name + " " + family_name);
                startActivity(intent);
                finish();
            }
        } else {
            // Prompt user to enter credentials
            Toast.makeText(getApplicationContext(),
                    "Please enter the required details marked with *", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * Method to make json array request where response starts with [
     */

    private void registerPatient(final String family_name, final String given_name,
                                 final String telephone, final String telephone_other, final String patient_number,
                                 final String address1, final String address2, final String address3, final String county_district, final String city_village,
                                 final String supporter, final String supporter_address, final String supporter_number, final String supporter_number_other) {

        // Tag used to cancel the request
        String tag_string_req = "req_register";

        StringRequest strReq = new StringRequest(Request.Method.POST, PATIENT_REGISTER_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Log.d(TAG, "Register Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        //String uuid = jObj.getString("uuid");

                        Toast.makeText(getApplicationContext(), "Patient successfully registered!", Toast.LENGTH_LONG).show();

                        Intent intentPatient = new Intent(getApplicationContext(), LoadPatients.class);
                        intentPatient.putExtra("page", "patient");
                        getApplication().startService(intentPatient);

                        // Launch login activity
                        Intent intent = new Intent(getApplicationContext(), Profile.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("name", given_name + " " + family_name);
                        startActivity(intent);
                        finish();
                    }
                    /*else {
                        //Error occurred in registration. Get the error message
                        Toast.makeText(getApplicationContext(), jObj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                    */

                    hideDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("family_name", family_name);
                params.put("given_name", given_name);
                params.put("telephone", telephone);
                params.put("telephone_other", telephone_other);
                params.put("patient_number", patient_number);
                params.put("patient_type", patient_type);
                params.put("gender", gender);
                params.put("birthdate", birthdate);
                params.put("birthdate_estimated", isEstimated);
                params.put("address1", address1);
                params.put("address2", address2);
                params.put("address3", address3);
                params.put("county_district", county_district);
                params.put("city_village", city_village);
                params.put("supporter", supporter);
                params.put("supporter_address", supporter_address);
                params.put("supporter_number", supporter_number);
                params.put("supporter_number_other", supporter_number_other);
                params.put("service_delivery_point", location_id);
                params.put("location_id", AppController.getInstance().getSessionManager().getUserDetails().get("location_id"));
                params.put("uuid", AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                JSONObject JSONparams = new JSONObject(params);
                Log.d("Params", JSONparams.toString());

                return params;
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


    public void Submit(View view) {
        validation();
    }
}
