package org.aihdint.aihd.patient;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.adapters.models.PatientAdapter;
import org.aihdint.aihd.services.LoadPatients;

import java.util.ArrayList;
import java.util.List;

public class Patients extends AppCompatActivity {

    //private String TAG = MainActivity.class.getSimpleName();

    private List<Person> contactList;
    private List<Person> personList;
    private PatientAdapter adapter;
    private String IsForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        IsForm = intent.getStringExtra("isForm");


        EditText inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        contactList = new ArrayList<>();
        personList = new ArrayList<>();

        adapter = new PatientAdapter(this, contactList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(adapter);

        /*
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        */


        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            List<Person> person_count = Select.from(Person.class)
                    .where(Condition.prop("_status").eq("0"))
                    .list();

            if (person_count.size() < 1) {

                Intent intentPatient = new Intent(getApplicationContext(), LoadPatients.class);
                getApplication().startService(intentPatient);

                getPatients();
            } else {
                getPatients();
            }
        } else {
            getPatients();
            //Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

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


    public void getPatients() {
        // Reading all contacts
        Log.d("Reading: ", "Reading all persons..");


        List<Person> allpersons = Person.listAll(Person.class);
        List<Person> persons = Select.from(Person.class).limit("10").list();
        for (Person cn : persons) {
            // adding each child node to HashMap key => value
            Person person = new Person();
            person.set_id(cn.get_id());
            person.setFamily_name(cn.getFamily_name());
            person.setGiven_name(cn.getGiven_name());
            person.set_status("0");
            person.setIsReport(IsForm);
            // adding contact to contact list
            contactList.add(person);
            adapter.notifyDataSetChanged();
        }


        for (Person pn : allpersons) {
            // adding each child node to HashMap key => value
            Person person = new Person();
            person.set_id(pn.get_id());
            person.setFamily_name(pn.getFamily_name());
            person.setGiven_name(pn.getGiven_name());
            person.set_status("0");
            person.setIsReport(IsForm);
            // adding contact to contact list
            personList.add(person);
        }
    }

    void filter(String text) {
        @SuppressWarnings("unchecked") List<Person> temp = new ArrayList();
        contactList = personList;
        for (Person d : contactList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            String name = d.getFamily_name() + " " + d.getGiven_name();
            if (name.toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }


}