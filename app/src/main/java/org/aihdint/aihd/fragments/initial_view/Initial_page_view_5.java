package org.aihdint.aihd.fragments.initial_view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.forms.DM_Initial_View;
import org.json.JSONArray;
import org.json.JSONObject;

public class Initial_page_view_5 extends Fragment {

    private TextView textViewTreatment, textViewDrug, textViewFrequency;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_5, container, false);

        textViewTreatment = view.findViewById(R.id.treatment);
        textViewDrug = view.findViewById(R.id.drug);
        textViewFrequency = view.findViewById(R.id.frequency);

        setMedicine(DM_Initial_View.json);

        return view;
    }

    public void setMedicine(String response) {
        try {

            JSONObject jsonObj = new JSONObject(response);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    //for (int j = 165253; j < 165284; j++) {

                    switch (concept.getString("concept_id")) {
                        case "1282":
                            textViewTreatment.append(Common.conceptAnswer(concept, "1282") + " \n");
                            break;
                        case "1443":
                            textViewDrug.append(String.format("%s mg", concept.getString("concept_answer")) + " \n");
                            break;
                        case "160855":
                            textViewFrequency.append(Common.conceptAnswer(concept, "160855") + " \n");
                            break;
                        default:
                            break;

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
