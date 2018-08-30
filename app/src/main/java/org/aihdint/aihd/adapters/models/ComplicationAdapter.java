package org.aihdint.aihd.adapters.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.Complications;

import java.util.List;

/**
 * Developed by Rodney on 10/10/2017.
 */

public class ComplicationAdapter extends RecyclerView.Adapter<ComplicationAdapter.MyViewHolder> {

    private Context mContext;
    private List<Complications> complicationList;

    public ComplicationAdapter(Context mContext, List<Complications> complicationList) {
        this.mContext = mContext;
        this.complicationList = complicationList;

    }

    @Override
    public ComplicationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_complications, parent, false);

        return new ComplicationAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewComplication, textViewDiagnosis, textViewDate, textViewComment;

        private MyViewHolder(View view) {
            super(view);
            this.textViewComplication = view.findViewById(R.id.complication);
            this.textViewDiagnosis = view.findViewById(R.id.complication_diagnosis);
            this.textViewDate = view.findViewById(R.id.diagnosis_date);
            this.textViewComment = view.findViewById(R.id.diagnosis_comment);
        }


    }

    @Override
    public void onBindViewHolder(final ComplicationAdapter.MyViewHolder holder, int position) {
        final Complications complications = complicationList.get(position);

        holder.textViewComplication.setText(complications.getComplication());
        holder.textViewDiagnosis.setText(complications.getDiagnosis());
        holder.textViewDate.setText(complications.getDate());
        holder.textViewComment.setText(complications.getComment());

    }

    @Override
    public int getItemCount() {
        return complicationList.size();
    }


}


