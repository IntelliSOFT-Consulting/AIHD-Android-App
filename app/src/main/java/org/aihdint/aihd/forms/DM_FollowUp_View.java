package org.aihdint.aihd.forms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.adapters.pages.DM_FollowUp_View_Adapter;

/**
 * Developed by Rodney on 26/03/2018.
 */

public class DM_FollowUp_View extends AppCompatActivity {

    //private static final String TAG = DM_Initial_View.class.getSimpleName();
    public static String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_htn_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        //report_id = intent.getStringExtra("report_id");
        String file_name = intent.getStringExtra("file_name");

        Log.d("Form Data", JSONFormBuilder.loadForm(this, "followup", file_name) + "");
        json = JSONFormBuilder.loadForm(this, "followup", file_name);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_FollowUp_View_Adapter adapter = new DM_FollowUp_View_Adapter(getSupportFragmentManager(), tabLayout.getTabCount());
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
                /*No Action on Unselect*/
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                /*No Action on reselected*/
            }
        });

    }

}
