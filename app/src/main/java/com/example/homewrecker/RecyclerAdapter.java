package com.example.homewrecker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private ArrayList<Tugas> listTugas;

    public RecyclerAdapter(ArrayList<Tugas> listTugas) {
        this.listTugas = listTugas;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView matkulTxt;
        private TextView tugasTxt;
        private TextView dateTxt;
        private TextView timeTxt;

        public MyViewHolder(final View view) {
            super(view);
            matkulTxt = view.findViewById(R.id.matkulTxt);
            tugasTxt = view.findViewById(R.id.tugasTxt);
            dateTxt = view.findViewById(R.id.dateTxt);
            timeTxt = view.findViewById(R.id.timeTxt);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_tasks, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
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
