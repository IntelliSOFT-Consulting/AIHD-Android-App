package org.aihdint.aihd;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.Report;
import org.aihdint.aihd.adapters.models.PatientReportAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Rodney on 28/03/2018.
 */

public class View_Reports extends AppCompatActivity {

    //private String TAG = MainActivity.class.getSimpleName();

    private EditText inputSearch;
    private List<Report> reportList;
    private PatientReportAdapter adapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView =  findViewById(R.id.my_recycler_view);

        reportList = new ArrayList<>();

        adapter = new PatientReportAdapter(this, reportList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        getPatientsReports();

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                filter(s.toString());

                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });


    }

    public void getPatientsReports(){
        // Reading all contacts
        Log.d("Reading: ", "Reading all reports..");

            /*List<Report> reports = database.getReports();

            for (Report rp : reports) {
                // adding each child node to HashMap key => value
                Report report = new Report();
                report.setID(rp.getID());
                report.setName(rp.getName());
                report.setDate(rp.getDate());
                report.setImage(rp.getImage());
                reportList.add(report);
            }

            */

        adapter.notifyDataSetChanged();

        Log.d("List Size ", String.valueOf(reportList.size()));

    }

    void filter(String text){
        List<Report> temp = new ArrayList();
        for(Report d: reportList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }

}
