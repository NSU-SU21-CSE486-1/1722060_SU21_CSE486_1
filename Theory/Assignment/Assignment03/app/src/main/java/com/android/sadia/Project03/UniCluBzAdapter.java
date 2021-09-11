package com.android.sadia.Project03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class UniCluBzAdapter extends RecyclerView.Adapter<UniCluBzAdapter.UniCluBzHolder> {

    private List<UniCluBzList> uniCluBzLists = new ArrayList<>();


    @NonNull
    @NotNull
    @Override
    public UniCluBzHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.uniclubzlist_item, parent, false);
        return new UniCluBzHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UniCluBzHolder holder, int position) {

        UniCluBzList currentUniCluBzList = uniCluBzLists.get(position);
        holder.textView1.setText(currentUniCluBzList.getUniversity_name());
        holder.textView2.setText(currentUniCluBzList.getDepartment());
        holder.textView3.setText(currentUniCluBzList.getStudent_id());
        holder.textView4.setText(currentUniCluBzList.getStudy_level());
        holder.textView5.setText(String.valueOf(currentUniCluBzList.getEmail()));

    }

    @Override
    public int getItemCount() {
        return uniCluBzLists.size();
    }

    public void setUniCluBzLists(List<UniCluBzList> uniCluBzLists){
        this.uniCluBzLists = uniCluBzLists;
        notifyDataSetChanged();
    }

    class UniCluBzHolder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;
        private TextView textView5;



        public UniCluBzHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.show_university);
            textView2 = itemView.findViewById(R.id.show_department);
            textView3 = itemView.findViewById(R.id.show_student_id);
            textView4 = itemView.findViewById(R.id.show_study_level);
            textView5 = itemView.findViewById(R.id.show_email_address);
        }
    }
}
