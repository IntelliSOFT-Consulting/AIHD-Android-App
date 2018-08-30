package org.aihdint.aihd.fragments.followup_view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.R;
import org.aihdint.aihd.forms.DM_Initial_View;
import org.aihdint.aihd.model.Concepts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Followup_page_view_4 extends Fragment {

    private TextView textViewTreatment, textViewDrug, textViewFrequency;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_5, container, false);

        textViewTreatment = view.findViewById(R.id.treatment);
        textViewDrug = view.findViewById(R.id.drug);
        textViewFrequency = view.findViewById(R.id.frequency);

        viewForm(DM_Initial_View.json);

        return view;
    }

    public void viewForm(String response) {

        try {
            JSONObject jsonObj = new JSONObject(response);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    //for (int j = 165253; j < 165284; j++) {
                    setMedicine(concept);

                }
            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }
    }

    public void setMedicine(JSONObject concept) {
        try {

            switch (concept.getString("concept_id")) {
                case "1282":
                    textViewTreatment.append(conceptAnswer(concept, "1282") + " \n");
                    break;
                case "1443":
                    textViewDrug.append(String.format("%s mg", concept.getString("concept_answer")) + " \n");
                    break;
                case "160855":
                    textViewFrequency.append(conceptAnswer(concept, "160855") + " \n");
                    break;
                default:
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String conceptAnswer(JSONObject concept, String concept_id) {
        String value = "";
        try {
            if (concept.getString("concept_id").equals(concept_id)) {
                List<Concepts> answer = Select.from(Concepts.class)
                        .where(Condition.prop("conceptid").eq(concept.getString("concept_answer")))
                        .limit("1")
                        .list();

                for (Concepts cpts : answer) {
                    // adding each child node to HashMap key => value
                    value = cpts.getConcept_answer();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}

