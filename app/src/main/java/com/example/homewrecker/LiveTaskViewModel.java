package com.example.homewrecker;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class LiveTaskViewModel extends AndroidViewModel {

    private LiveTaskRepository repository;
    private LiveData<ArrayList<LiveTask>> allTasks;
    public LiveTaskViewModel(Application application) {
        super(application);
        repository = new LiveTaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    public void insert (LiveTask liveTask) {
        repository.insert(liveTask);
    }

    public void update (LiveTask liveTask) {
        repository.update(liveTask);
    }

    public void delete (LiveTask liveTask) {
        repository.delete(liveTask);
    }

    public void deleteAllTasks () {
        repository.deleteAllTasks();
    }

    public LiveData<ArrayList<LiveTask>> getAllTasks() {
        return allTasks;
    }
}
