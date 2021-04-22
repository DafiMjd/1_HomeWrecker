package com.example.homewrecker;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MataKuliah implements Parcelable {
    private String fullName;
    private String shortName;
    private ArrayList<Tugas> listTugas;

    public MataKuliah(String fullName, String shortName) {
        listTugas = new ArrayList<>();
        this.fullName = fullName;
        this.shortName = shortName;
    }

    protected MataKuliah(Parcel in) {
        fullName = in.readString();
        shortName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(shortName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MataKuliah> CREATOR = new Creator<MataKuliah>() {
        @Override
        public MataKuliah createFromParcel(Parcel in) {
            return new MataKuliah(in);
        }

        @Override
        public MataKuliah[] newArray(int size) {
            return new MataKuliah[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public ArrayList<Tugas> getListTugas() {
        return listTugas;
    }

    public void addTugas(String name, String description, String dueDate, String dueTime) {
        this.listTugas.add(new Tugas(name, description, dueDate, dueTime));
    }

    @Override
    public String toString() {
        return this.getShortName();
    }
}
