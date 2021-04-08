package com.example.homewrecker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.TugasViewHolder>{
    private ArrayList<Tugas> listTugas;

    public TugasAdapter(ArrayList<Tugas> listTugas) {
        this.listTugas = listTugas;
    }

    public class TugasViewHolder extends  RecyclerView.ViewHolder{
        private TextView matkulTxt;
        private TextView tugasTxt;
        private TextView dateTxt;
        private TextView timeTxt;

        public TugasViewHolder(final View view) {
            super(view);
            matkulTxt = view.findViewById(R.id.matkulTxt);
            tugasTxt = view.findViewById(R.id.tugasTxt);
            dateTxt = view.findViewById(R.id.dateTxt);
            timeTxt = view.findViewById(R.id.timeTxt);
        }
    }

    @NonNull
    @Override
    public TugasAdapter.TugasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.users_tasks, parent, false);
        return new TugasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasAdapter.TugasViewHolder holder, int position) {
        String matkul = listTugas.get(position).getMatkul();
        String tugas = listTugas.get(position).getTugas();
        String dueDate = listTugas.get(position).getDueDate();
        String dueTime = listTugas.get(position).getDueTime();

        holder.matkulTxt.setText(matkul);
        holder.tugasTxt.setText(tugas);
        holder.dateTxt.setText(dueDate);
        holder.timeTxt.setText(dueTime);
    }

    @Override
    public int getItemCount() {
        return listTugas.size();
    }

}
