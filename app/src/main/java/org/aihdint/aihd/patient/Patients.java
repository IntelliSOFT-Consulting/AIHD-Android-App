package org.aihdint.aihd.patient;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import org.aihdint.aihd.R;
import org.aihdint.aihd.adapters.models.PatientAdapter;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.services.LoadPatients;

import java.util.ArrayList;
import java.util.List;

public class Patients extends AppCompatActivity implements SwipyRefreshLayout.OnRefreshListener {

    //private String TAG = MainActivity.class.getSimpleName();

    private List<Person> contactList;
    private List<Person> personList;
    private PatientAdapter adapter;
    private String IsForm;
    private SwipyRefreshLayout swipeRefreshLayout;
    private Button buttonRegister;

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

        swipeRefreshLayout = findViewById(R.id.swipyrefreshlayout);
        EditText inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        buttonRegister = findViewById(R.id.btnRegister);

        contactList = new ArrayList<>();
        personList = new ArrayList<>();

        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new PatientAdapter(this, contactList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(adapter);

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


        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        getPatients();
                                    }
                                }
        );

    }


    public void getPatients() {
        contactList.clear();
        personList.clear();

        List<Person> allpersons = Person.findWithQuery(Person.class, "SELECT * FROM PERSON ORDER BY FAMILYNAME ASC");

        for (Person pn : allpersons) {
            // adding each child node to HashMap key => value
            Person person = new Person();
            person.set_id(pn.get_id());
            person.setFamily_name(pn.getFamily_name());
            person.setGiven_name(pn.getGiven_name());
            person.setGender(pn.getGender());
            // person.setNational_id(pn.getNational_id());
            person.setTelephone(pn.getTelephone());
            person.set_status("0");
            person.setIsReport(IsForm);
            person.setIsDead(pn.getIsDead());
            person.setIdentifier(pn.getIdentifier());
            // adding contact to contact list
            personList.add(person);
            contactList.add(person);
            adapter.notifyDataSetChanged();
        }

        swipeRefreshLayout.setRefreshing(false);

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

        Log.d("TempSize", String.valueOf(temp.size()));
        if (temp.size() > 0) {
            buttonRegister.setVisibility(View.GONE);
        } else {
            buttonRegister.setVisibility(View.VISIBLE);
        }
        //update recyclerview
        adapter.searchList(temp);
    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        Log.d("Patients", "Refresh triggered at " + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            Intent servicePatients = new Intent(getApplicationContext(), LoadPatients.class);
            servicePatients.putExtra("uuid", AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));
            servicePatients.putExtra("mfl", AppController.getInstance().getSessionManager().getUserDetails().get("mfl_code"));
            //servicePatients.putExtra("nationalid", AppController.getInstance().getSessionManager().getUserDetails().get("national_id"));
            servicePatients.putExtra("telephone", AppController.getInstance().getSessionManager().getUserDetails().get("telephone"));
            startService(servicePatients);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getPatients();
                }
            }, 2000);
        } else {
            swipeRefreshLayout.setRefreshing(false);
        }

    }

    public void register(View view) {
        Intent add_patient = new Intent(getApplicationContext(), Register.class);
        startActivity(add_patient);
        finish();
    }
}
