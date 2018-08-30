package org.aihdint.aihd.fragments.initial_view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.forms.DM_Initial_View;
import org.aihdint.aihd.model.Complications;
import org.aihdint.aihd.adapters.models.ComplicationAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Initial_page_view_4 extends Fragment {

    private List<Complications> complicationList;
    private ComplicationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_4, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        complicationList = new ArrayList<>();
        adapter = new ComplicationAdapter(getActivity(), complicationList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        allComplication(DM_Initial_View.json);

        return view;
    }


    public void allComplication(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {

                Complications complications = null;

                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    String date = "";
                    String comment = "";
                    String complication = "";
                    String diagnosis = "";
                    //if(concept.getString("concept_id").equals("159948")){
                    //date = concept.getString("concept_answer");
                    //}
                    if (concept.getString("concept_id").equals("6042")) {
                        complication = Common.conceptAnswer(concept, "6042");
                    }

                    if (concept.getString("concept_id").equals("165127") || concept.getString("concept_id").equals("159948")) {

                        if (concept.getString("concept_id").equals("159948")) {
                            date = concept.getString("concept_answer");
                        } else {
                            comment = concept.getString("comment");
                            diagnosis = Common.conceptAnswer(concept, "165127");
                        }
                    }

                    complications = new Complications(complication, diagnosis, date, comment);

                }

                complicationList.add(complications);
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
