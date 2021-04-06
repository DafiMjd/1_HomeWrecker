package com.example.homewrecker;

import java.util.Date;

public class Tugas {
    private String tugas;
    private String description;
    private String matkul;
    private String dueDate;
    private String dueTime;

    public Tugas(String matkul, String tugas, String description, String dueDate, String dueTime) {
        this.matkul = matkul;
        this.tugas = tugas;
        this.description = description;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    public String getTugas() {
        return tugas;
    }

    public String getMatkul() {
        return matkul;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

}
