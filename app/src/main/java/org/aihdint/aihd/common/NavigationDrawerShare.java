package org.aihdint.aihd.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.aihdint.aihd.R;
import org.aihdint.aihd.Home;
import org.aihdint.aihd.Login;
import org.aihdint.aihd.resources.HelpdeskActivity;
import org.aihdint.aihd.resources.ResourcesActivity;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.patient.Patients;

/**
 * Developed by Rodney on 20/03/2018.
 */

public class NavigationDrawerShare implements NavigationView.OnNavigationItemSelectedListener {

    private Context mContext;

    public NavigationDrawerShare(Context mContext) {
        this.mContext = mContext;
    }

    public void createDrawer(Toolbar toolbar) {

        // Displaying user information from shared preferences

        PackageInfo packageinfo = null;
        try {
            packageinfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assert packageinfo != null;
        String Version = packageinfo.versionName;

        DrawerLayout drawer = ((Activity) mContext).findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                (Activity) mContext, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = ((Activity) mContext).findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView = navigationView.getHeaderView(0);
        TextView nav_version = hView.findViewById(R.id.nav_version);
        TextView nav_name = hView.findViewById(R.id.nav_name);
        String location = AppController.getInstance().getSessionManager().getUserDetails().get("location_id");
        String name = AppController.getInstance().getSessionManager().getUserDetails().get("name");
        if (location.length() > 0) {
            location = location.replace("_", " ");
            location = location.substring(0, 1).toUpperCase() + location.substring(1);
        }

        try {
            nav_version.setText(String.format("Version %s", Version));
            nav_name.setText(String.format("%s - %s", name, location));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public void onBackPressed() {
        DrawerLayout drawer = ((Activity) mContext).findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            ((Activity) mContext).onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent home = new Intent(mContext.getApplicationContext(), Home.class);
            mContext.startActivity(home);
        } /*else if (id == R.id.nav_dm_initial) {
            Intent dm_initial = new Intent(mContext.getApplicationContext(), Patients.class);
            dm_initial.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            dm_initial.putExtra("isForm", "1");
            mContext.startActivity(dm_initial);
            ((Activity)mContext).finish();
        } */ else if (id == R.id.nav_dm_follow_up) {
            Intent dm_followup = new Intent(mContext.getApplicationContext(), Patients.class);
            dm_followup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            dm_followup.putExtra("isForm", "2");
            mContext.startActivity(dm_followup);
            ((Activity) mContext).finish();
        } else if (id == R.id.nav_past_forms) {
            Intent forms = new Intent(mContext.getApplicationContext(), Patients.class);
            forms.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            forms.putExtra("isForm", "3");
            mContext.startActivity(forms);
            ((Activity)mContext).finish();
        }/* else if (id == R.id.nav_add_patients) {
            Intent add_patient = new Intent(mContext.getApplicationContext(), Register.class);
            mContext.startActivity(add_patient);
            ((Activity) mContext).finish();
        } */ else if (id == R.id.nav_patients) {
            Intent patient = new Intent(mContext.getApplicationContext(), Patients.class);
            patient.putExtra("isForm", "0");
            mContext.startActivity(patient);
            ((Activity) mContext).finish();
        } else if (id == R.id.nav_resources) {
            Intent resources = new Intent(mContext.getApplicationContext(), ResourcesActivity.class);
            mContext.startActivity(resources);
            ((Activity) mContext).finish();
        }else if (id == R.id.nav_helpdesk) {
            Intent resources = new Intent(mContext.getApplicationContext(), HelpdeskActivity.class);
            mContext.startActivity(resources);
            ((Activity) mContext).finish();
        }else if (id == R.id.nav_share) {
            Alerts launch = new Alerts(mContext);
            //launch.alert_msg(this,"The Long Road","Maybe its a hard, loong road");
            launch.share(mContext);
        } else if (id == R.id.nav_logout) {
            // Session manager
            AppController.getInstance().getSessionManager().setLogin(false);

            Intent login = new Intent(mContext.getApplicationContext(), Login.class);
            mContext.startActivity(login);
            ((Activity) mContext).finish();
        }

        DrawerLayout drawer = ((Activity) mContext).findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}