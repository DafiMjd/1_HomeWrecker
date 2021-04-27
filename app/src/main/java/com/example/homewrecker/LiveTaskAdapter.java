package com.example.homewrecker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LiveTaskAdapter extends RecyclerView.Adapter<LiveTaskAdapter.LiveTaskHolder> {
    private List<LiveTask> liveTask = new ArrayList<>();

    @NonNull
    @Override
    public LiveTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_tasks, parent, false);
        return new LiveTaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveTaskHolder holder, int position) {
        LiveTask currentLiveTask = liveTask.get(position);
        holder.matkulTxt.setText(currentLiveTask.getMatkulShortName());
        holder.tugasTxt.setText(currentLiveTask.getTugasName());
        holder.dateTxt.setText(currentLiveTask.getDueDate());
        holder.timeTxt.setText(currentLiveTask.getDueTime());
        holder.priorityTxt.setText(String.valueOf(currentLiveTask.getPriority()));
    }

    @Override
    public int getItemCount() {
        return liveTask.size();
    }

    public void setLiveTask(List<LiveTask> liveTask) {
        this.liveTask = liveTask;
        notifyDataSetChanged();
    }

    class LiveTaskHolder extends RecyclerView.ViewHolder {
        private TextView matkulTxt;
        private TextView tugasTxt;
        private TextView dateTxt;
        private TextView timeTxt;
        private TextView priorityTxt;

        public LiveTaskHolder(View view) {
            super(view);
            matkulTxt = view.findViewById(R.id.matkulTxt);
            tugasTxt = view.findViewById(R.id.tugasTxt);
            dateTxt = view.findViewById(R.id.dateTxt);
            timeTxt = view.findViewById(R.id.timeTxt);
            priorityTxt = view.findViewById(R.id.priorityTxt);
        }
    }
}
