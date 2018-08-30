package org.aihdint.aihd.adapters.pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.aihdint.aihd.fragments.followup_view.Followup_page_view_1;
import org.aihdint.aihd.fragments.followup_view.Followup_page_view_2;
import org.aihdint.aihd.fragments.followup_view.Followup_page_view_3;
import org.aihdint.aihd.fragments.followup_view.Followup_page_view_4;

/**
 * Created : dennis on 3/23/18.
 */

public class DM_FollowUp_View_Adapter extends FragmentStatePagerAdapter {

    private int tabsNumber;

    public DM_FollowUp_View_Adapter(FragmentManager fm, int tabsNumber) {
        super(fm);
        this.tabsNumber = tabsNumber;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Followup_page_view_1();
            case 1:
                return new Followup_page_view_2();
            case 2:
                return new Followup_page_view_3();
            case 3:
                return new Followup_page_view_4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }

}
