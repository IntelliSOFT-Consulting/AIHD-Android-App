package org.aihdint.aihd.patient;

import android.annotation.SuppressLint;
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

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.adapters.models.PatientAdapter;

import java.util.ArrayList;
import java.util.List;


public class Patient_Reports extends AppCompatActivity {

    //private String TAG = MainActivity.class.getSimpleName();

    private List <Person> contactList;
    private PatientAdapter adapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        EditText inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView =  findViewById(R.id.my_recycler_view);

        contactList = new ArrayList<>();

        adapter = new PatientAdapter(this, contactList);

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

    public void getPatients(){
        // Reading all contacts
        Log.d("Reading: ", "Reading all persons..");
        /*List<Person> persons = database.getAllPersons();

        for (Person cn : persons) {
            // adding each child node to HashMap key => value
            Person person = new Person();
            //person.setID(cn.getID());
            //person.setName(cn.getName());
            //person.setStatus("1");
            // adding contact to contact list
            contactList.add(person);
            adapter.notifyDataSetChanged();
        }
        */
    }

    void filter(String text){
        List<Person> temp = new ArrayList();
        for(Person d: contactList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if ((d.getFamily_name() + " " + d.getGiven_name()).toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }
}