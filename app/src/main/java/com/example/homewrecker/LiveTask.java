package com.example.homewrecker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "livetask_table")
public class LiveTask {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String matkulFullName;
    private String matkulShortName;
    private String tugasName;
    private String description;
    private String dueDate;
    private String dueTime;
    private boolean done;
    private int priority;

    public LiveTask(String matkulFullName, String matkulShortName, String tugasName, String description, String dueDate, String dueTime, int priority) {
        this.matkulFullName = matkulFullName;
        this.matkulShortName = matkulShortName;
        this.tugasName = tugasName;
        this.description = description;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.done = false;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMatkulFullName() {
        return matkulFullName;
    }

    public String getMatkulShortName() {
        return matkulShortName;
    }

    public String getTugasName() {
        return tugasName;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public boolean isDone() {
        return done;
    }

    public int getPriority() {
        return priority;
    }
}
