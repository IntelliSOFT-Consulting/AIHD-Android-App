package org.aihdint.aihd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.model.Forms;
import org.aihdint.aihd.patient.Patients;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.services.LoadFiles;

import java.util.List;

public class Home extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        List<Forms> forms = Select.from(Forms.class).where(Condition.prop("status").eq("0")).list();
        for (Forms cn : forms) {
            //Log.d("Form ID",cn.getId()+"");
            Intent intentPatient = new Intent(getApplicationContext(), LoadFiles.class);
            intentPatient.putExtra("file_path", Environment.getExternalStorageDirectory() + "/aihd/" + cn.getForm_type() + "/" + cn.getForm_name());
            intentPatient.putExtra("form_id", cn.getId());
            getApplication().startService(intentPatient);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent patient = new Intent(getApplicationContext(), Patients.class);
                startActivity(patient);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
