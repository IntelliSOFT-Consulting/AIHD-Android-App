package org.aihdint.aihd.adapters.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aihdint.aihd.forms.DM_FollowUp;
import org.aihdint.aihd.forms.DM_Initial;
import org.aihdint.aihd.patient.Profile;
import org.aihdint.aihd.R;
import org.aihdint.aihd.model.Person;

import java.util.List;

/**
 * Developed by Rodney on 10/10/2017.
 */

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MyViewHolder> {

    private Context mContext;
    private List<Person> patientList;

    public PatientAdapter(Context mContext, List<Person> patientList) {
        this.mContext = mContext;
        this.patientList = patientList;

    }

    @Override
    public PatientAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_patient, parent, false);

        return new PatientAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;

        private MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.name = view.findViewById(R.id.name);
        }

        @Override
        public void onClick(final View view) {

            @SuppressWarnings("deprecation") final Person person = patientList.get(getPosition());

            if (person.getIsReport().matches("1")) {
                Intent graph = new Intent(view.getContext(), DM_Initial.class);
                graph.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                graph.putExtra("patient_id", person.get_id());
                graph.putExtra("name", person.getFamily_name() + " " + person.getGiven_name());
                mContext.startActivity(graph);
            } else if (person.getIsReport().matches("2")) {
                Intent graph = new Intent(view.getContext(), DM_FollowUp.class);
                graph.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                graph.putExtra("patient_id", person.get_id());
                graph.putExtra("name", person.getFamily_name() + " " + person.getGiven_name());
                mContext.startActivity(graph);
            } else {
                Intent graph = new Intent(view.getContext(), Profile.class);
                graph.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                graph.putExtra("patient_id", person.get_id());
                graph.putExtra("name", person.getFamily_name() + " " + person.getGiven_name());
                mContext.startActivity(graph);
            }

        }
    }

    @Override
    public void onBindViewHolder(final PatientAdapter.MyViewHolder holder, int position) {
        final Person person = patientList.get(position);

        holder.name.setText(String.format("%s %s", person.getFamily_name(), person.getGiven_name()));

    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public void searchList(List<Person> list) {
        patientList = list;
        notifyDataSetChanged();
    }

    /*
    public void clear() {
        int size = this.patientList.size();
        this.patientList.clear();
        notifyItemRangeRemoved(0, size);
    }
    */
}


