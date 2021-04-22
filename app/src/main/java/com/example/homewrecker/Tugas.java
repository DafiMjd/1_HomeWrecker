package com.example.homewrecker;


public class Tugas {
    final boolean DONE = true;
    final boolean NOT_DONE = false;

    private String name;
    private String description;
    private String dueDate;
    private String dueTime;
    private boolean condition;

    public Tugas(String name, String description, String dueDate, String dueTime) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.condition = NOT_DONE;
    }

    public String getName() {
        return name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
}
