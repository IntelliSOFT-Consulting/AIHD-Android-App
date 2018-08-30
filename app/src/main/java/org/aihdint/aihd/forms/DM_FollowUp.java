package org.aihdint.aihd.forms;

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

import org.aihdint.aihd.common.File_Upload;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.model.Forms;
import org.aihdint.aihd.adapters.pages.DM_FollowUp_Adapter;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.fragments.followup.FragmentModelFollowUp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by Rodney 4/24/18
 */

public class DM_FollowUp extends AppCompatActivity implements FragmentModelFollowUp.FragStateChangeListener {

    private JSONArray jsonArry1, jsonArry2, jsonArry3, jsonArry4;
    private String encounter_date, file_name, form_id, patient_id;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_follow_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        FragmentModelFollowUp.getInstance().setListener(this);

        Intent intent = getIntent();
        patient_id = intent.getStringExtra("patient_id");

        file_name = "DM_HTN_FOLLOWUP_" + System.currentTimeMillis() + ".json";
        form_id = System.currentTimeMillis() + "_" + patient_id;

        jsonArry1 = new JSONArray();
        jsonArry2 = new JSONArray();
        jsonArry3 = new JSONArray();
        jsonArry4 = new JSONArray();

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_FollowUp_Adapter adapter = new DM_FollowUp_Adapter
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
    public void followUpOne(String encounterDate, JSONArray params) {
        encounter_date = encounterDate;
        jsonArry1 = params;
    }

    @Override
    public void followUpTwo(JSONArray params) {
        jsonArry2 = params;
    }


    @Override
    public void followUpThree(JSONArray params) {
        jsonArry3 = params;
    }

    @Override
    public void followUpFour(JSONArray params) {
        jsonArry4 = params;
    }


    public void validate(View view) {

        File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/followup");
        if (!dir.mkdirs()) {
            Log.e("Directory Message", "Directory not created");
        }

        File file = new File(dir, file_name);

        try {

            JSONArray jsonArray = JSONFormBuilder.concatArray(jsonArry1, jsonArry2, jsonArry3, jsonArry4);
            JSONObject jsonForm = new JSONObject();

            String creator = AppController.getInstance().getSessionManager().getUserDetails().get("user_id");

            try {
                jsonForm.put("formDescription", "Diabetes Clinical Follow Up Form");
                jsonForm.put("formEncounterType", "2da542a4-f87d-11e7-8eb4-37dc291c1b12");
                jsonForm.put("formUuid", "fa3295cb-07d7-4554-972b-ce959d10732c");
                jsonForm.put("formVersion", "1.0");
                jsonForm.put("formUILocation", "patientDashboard.visitActions");
                jsonForm.put("formOrder", "2");
                jsonForm.put("encounterDate", encounter_date);
                jsonForm.put("encounterProvider", creator);
                jsonForm.put("location_id", AppController.getInstance().getSessionManager().getUserDetails().get("location_id"));
                jsonForm.put("patient_id", patient_id);
                jsonForm.put("obs", jsonArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(jsonForm.toString());
            pw.flush();
            pw.close();
            f.close();

            Forms forms = new Forms(form_id, file_name, creator, patient_id, "followup", encounter_date, "0");
            id = forms.save();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("Error", "*** File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast.makeText(getBaseContext(), file_name + " file saved", Toast.LENGTH_SHORT).show();
        boolean isConnected = File_Upload.connectivity(getApplicationContext());
        if (isConnected) {
            File_Upload.upload(this, Environment.getExternalStorageDirectory() + "/aihd/followup/" + file_name, id, null);
        } else {
            Toast.makeText(this, "No Internet Connection,Unable to upload file", Toast.LENGTH_SHORT).show();
        }

    }


}
