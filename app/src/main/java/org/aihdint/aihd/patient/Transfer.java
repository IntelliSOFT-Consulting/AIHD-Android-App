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
import org.aihdint.aihd.model.Location;

import java.util.ArrayList;
import java.util.List;

public class Transfer extends AppCompatActivity {

    private ProgressDialog pDialog;
    private String location_id, reason;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_discontinue);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        Spinner spinnerDesignation = findViewById(R.id.spinnerDesignation);
        Spinner spinnerLocation = findViewById(R.id.spinnerLocation);
        spinnerData(spinnerDesignation, "reason");
        spinnerData(spinnerLocation, "location");
    }

    public void spinnerData(final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        if (data.matches("reason")) {
            keyvalue.add(new KeyValue("", "Select Reason"));
            keyvalue.add(new KeyValue("", "Transferred Out"));
            keyvalue.add(new KeyValue("", "Unknown"));
        } else if (data.matches("location")) {
            //Add locations
            keyvalue.add(new KeyValue("", "Select Location"));

            List<Location> locations = Location.findWithQuery(Location.class, "SELECT * from LOCATION ORDER BY _name ASC ");
            for (Location ln : locations) {
                // adding each child node to HashMap key => value
                keyvalue.add(new KeyValue(ln.getID(), ln.getName()));
            }
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
                            if (data.matches("reason")) {
                                reason = value.getId();
                            }
                            break;
                        case R.id.spinnerLocation:
                            if (data.matches("location")) {
                                location_id = value.getId();
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
