package org.aihdint.aihd.patient;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.KeyValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Admission extends AppCompatActivity {

    private ProgressDialog pDialog;
    private String reason, designation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_admission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        EditText editTextAdmissionDate = findViewById(R.id.admission_date);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        editTextAdmissionDate.setText(dateFormat.format(new Date())); // it will show 16/07/2013

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        Spinner spinnerDesignation = findViewById(R.id.spinnerDesignation);
        spinnerData(spinnerDesignation, "designation");
    }

    public void spinnerData(final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        if (data.matches("reason")) {
            keyvalue.add(new KeyValue("", "Select Reason"));
            keyvalue.add(new KeyValue("", "Admitted with DKA"));
            keyvalue.add(new KeyValue("", "Admitted with Hypoglycemia"));
            keyvalue.add(new KeyValue("", "Other"));
        } else if (data.matches("designation")) {
            keyvalue.add(new KeyValue("", "Select Designation"));
            keyvalue.add(new KeyValue("", "Consultant"));
            keyvalue.add(new KeyValue("", "Medical officer"));
            keyvalue.add(new KeyValue("", "Clinical Officer"));
            keyvalue.add(new KeyValue("", "Nurse"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue keyValue = (KeyValue) parent.getSelectedItem();

                if (!keyValue.getId().isEmpty()) {

                    KeyValue value = (KeyValue) parent.getSelectedItem();
                    switch (spinner.getId()) {
                        case R.id.spinnerDesignation:
                            if (data.matches("designation")) {
                                designation = value.getId();
                            }
                            break;
                        default:
                            break;
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
}
