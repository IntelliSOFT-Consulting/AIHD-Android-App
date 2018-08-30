package org.aihdint.aihd.adapters.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.Report;

import java.util.List;

/**
 * Developed by Rodney on 10/10/2017.
 */

@SuppressWarnings("ALL")
public class PatientReportAdapter extends RecyclerView.Adapter<PatientReportAdapter.MyViewHolder> {

    private Context mContext;
    private List<Report> reportList;

    public PatientReportAdapter(Context mContext, List<Report> reportList) {
        this.mContext = mContext;
        this.reportList = reportList;

    }

    @Override
    public PatientReportAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_report, parent, false);

        return new PatientReportAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name, date;
        private ImageView imageView;

        private MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.name = view.findViewById(R.id.name);
            this.date = view.findViewById(R.id.date);
            this.imageView = view.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(final View view) {

            final Report report = reportList.get(getPosition());

            /*
            Intent graph = new Intent(view.getContext(), Patient_Reports.class);
            graph.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            graph.putExtra("id", report.getID());
            graph.putExtra("name", report.getName());
            graph.putExtra("date", report.getDate());
            mContext.startActivity(graph);
            */

            }
    }

    @Override
    public void onBindViewHolder(final PatientReportAdapter.MyViewHolder holder, int position) {
       final Report report = reportList.get(position);

        holder.name.setText(report.getName());
        holder.date.setText(report.getDate());

        byte[] imgByte = report.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        System.out.println("Data "+imgByte.length+" ...");

        holder.imageView.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public void searchList(List<Report> list){
        reportList = list;
        notifyDataSetChanged();
    }

    public void clear() {
        int size = this.reportList.size();
        this.reportList.clear();
        notifyItemRangeRemoved(0, size);
    }
}


