package org.aihdint.aihd.forms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.Forms;
import org.aihdint.aihd.adapters.models.FormAdapter;

import java.util.ArrayList;
import java.util.List;

public class DM_HTN_Forms extends AppCompatActivity {

    //private String TAG = MainActivity.class.getSimpleName();

    private List<Forms> formList;
    private List<Forms> allFormsList;
    private FormAdapter adapter;
    private String patient_id;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        patient_id = intent.getStringExtra("patient_id");

        EditText inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        allFormsList = new ArrayList<>();
        formList = new ArrayList<>();

        adapter = new FormAdapter(this, allFormsList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(adapter);

        getPatients();

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                filter(s.toString());
            }
        });


    }


    public void getPatients() {
        // Reading all contacts
        Log.d("Reading: ", "Reading all forms..");

        List<Forms> forms = Select.from(Forms.class)
                .where(Condition.prop("patientid").eq(patient_id))
                .orderBy("date")
                .list();

        for (Forms fn : forms) {
            // adding each child node to HashMap key => value
            Forms form = new Forms();
            form.setForm_id(fn.getForm_id());
            form.setForm_name(fn.getForm_name());
            form.setForm_type(fn.getForm_type());
            form.setStatus(fn.getStatus());
            form.setDate(fn.getDate());
            allFormsList.add(form);

            Log.d("Type", fn.getForm_type());
        }
    }

    void filter(String text) {
        @SuppressWarnings("unchecked") List<Forms> temp = new ArrayList();
        formList = allFormsList;
        for (Forms f : formList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            String name = f.getForm_name();
            if (name.toLowerCase().contains(text.toLowerCase())) {
                temp.add(f);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }


}