package com.example.homewrecker;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class TugasDatabase  implements Parcelable {
    private String matkulFullName;
    private String matkulShortName;
    private String tugasName;
    private String description;
    private String dueDate;
    private String dueTime;
    private boolean condition;

    public TugasDatabase(String matkulFullName, String matkulShortName, String tugasName, String description, String dueDate, String dueTime, boolean condition) {
        this.matkulFullName = matkulFullName;
        this.matkulShortName = matkulShortName;
        this.tugasName = tugasName;
        this.description = description;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.condition = condition;
    }

    protected TugasDatabase(Parcel in) {
        matkulFullName = in.readString();
        matkulShortName = in.readString();
        tugasName = in.readString();
        description = in.readString();
        dueDate = in.readString();
        dueTime = in.readString();
        condition = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(matkulFullName);
        dest.writeString(matkulShortName);
        dest.writeString(tugasName);
        dest.writeString(description);
        dest.writeString(dueDate);
        dest.writeString(dueTime);
        dest.writeByte((byte) (condition ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TugasDatabase> CREATOR = new Creator<TugasDatabase>() {
        @Override
        public TugasDatabase createFromParcel(Parcel in) {
            return new TugasDatabase(in);
        }

        @Override
        public TugasDatabase[] newArray(int size) {
            return new TugasDatabase[size];
        }
    };

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

    public boolean getConditon() {
        return condition;
    }
}
