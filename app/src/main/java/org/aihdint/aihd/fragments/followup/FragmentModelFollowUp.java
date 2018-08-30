package org.aihdint.aihd.fragments.followup;

import org.json.JSONArray;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FragmentModelFollowUp {
    public interface FragStateChangeListener {

        void followUpOne(String supporter_name, JSONArray params);

        void followUpTwo(JSONArray params);

        void followUpThree(JSONArray params);

        void followUpFour(JSONArray params);

    }

    private static FragmentModelFollowUp mInstance;
    private FragStateChangeListener mListener;

    private FragmentModelFollowUp() {
    }

    public static FragmentModelFollowUp getInstance() {
        if (mInstance == null) mInstance = new FragmentModelFollowUp();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }

    public void followUpOne(String supporter_name, JSONArray params) {
        if (mListener != null) {
            mListener.followUpOne(supporter_name, params);
        }
    }

    public void followUpTwo(JSONArray params) {
        if (mListener != null) {
            mListener.followUpTwo(params);
        }
    }

    public void followUpThree(JSONArray params) {
        if (mListener != null) {
            mListener.followUpThree(params);
        }
    }

    public void followUpFour(JSONArray params) {
        if (mListener != null) {
            mListener.followUpFour(params);
        }
    }

}



