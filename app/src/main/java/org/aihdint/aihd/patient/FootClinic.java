package org.aihdint.aihd.patient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.KeyValue;

import java.util.ArrayList;

public class FootClinic extends AppCompatActivity {

    private ProgressDialog pDialog;
    private String designation, visit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_foot_clinic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        Spinner spinnerDesignation = findViewById(R.id.spinnerDesignation);
        spinnerData(spinnerDesignation, "designation");
        Spinner spinnerVisit = findViewById(R.id.spinnerVisit);
        spinnerData(spinnerVisit, "visit");
    }

    public void spinnerData(final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        if (data.matches("visit")) {
            keyvalue.add(new KeyValue("", "Select Visit Type"));
            keyvalue.add(new KeyValue("", "New Visit"));
            keyvalue.add(new KeyValue("", "Revisit"));
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
                        case R.id.spinnerVisit:
                            if (data.matches("visit")) {
                                visit = value.getId();
                            }
                            break;
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
                //Nothing selected
            }
        });


    }
}
