package org.aihdint.aihd.fragments.initial;

import org.json.JSONArray;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FragmentModelInitial {
    public interface FragStateChangeListener {

        void initialOne(String date, JSONArray params);

        void initialTwo(JSONArray params);

        void initialThree(JSONArray params);

        void initialFour(JSONArray params);

        void initialFive(JSONArray params);

    }

    private static FragmentModelInitial mInstance;
    private FragStateChangeListener mListener;

    private FragmentModelInitial() {
    }

    public static FragmentModelInitial getInstance() {
        if (mInstance == null) mInstance = new FragmentModelInitial();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }

    public void initialOne(String date, JSONArray params) {
        if (mListener != null) {
            mListener.initialOne(date, params);
        }
    }

    public void initialTwo(JSONArray params) {
        if (mListener != null) {
            mListener.initialTwo(params);
        }
    }

    public void initialThree(JSONArray params) {
        if (mListener != null) {
            mListener.initialThree(params);
        }
    }

    public void initialFour(JSONArray params) {
        if (mListener != null) {
            mListener.initialFour(params);
        }
    }

    public void initialFive(JSONArray params) {
        if (mListener != null) {
            mListener.initialFive(params);
        }
    }

}

