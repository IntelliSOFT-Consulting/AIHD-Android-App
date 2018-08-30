package org.aihdint.aihd.adapters.pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.aihdint.aihd.fragments.followup.Followup_page_4;
import org.aihdint.aihd.fragments.followup.Followup_page_1;
import org.aihdint.aihd.fragments.followup.Followup_page_3;
import org.aihdint.aihd.fragments.followup.Followup_page_2;

/**
 * Created : dennis on 3/23/18.
 */

public class DM_FollowUp_Adapter extends FragmentStatePagerAdapter {

    private int tabsNumber;

    public DM_FollowUp_Adapter(FragmentManager fm, int tabsNumber) {
        super(fm);
        this.tabsNumber = tabsNumber;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Followup_page_1();
            case 1:
                return new Followup_page_2();
            case 2:
                return new Followup_page_3();
            case 3:
                return new Followup_page_4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }

}
