package com.example.homewrecker;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MatkulDatabase implements Parcelable {
    private ArrayList<MataKuliah> listMatkul;

    public MatkulDatabase() {
        listMatkul = new ArrayList<>();

        listMatkul = new ArrayList<>();
        listMatkul.add(new MataKuliah("Mobile Programming", "PPB"));
        listMatkul.add(new MataKuliah("Analisa dan Perancangan Sistem Informasi", "APSI"));
        listMatkul.add(new MataKuliah("Pengembangan Perangkat Lunak 1", "PPL1"));
        listMatkul.add(new MataKuliah("Proyek Perangkat Lunak 4", "PPL4"));

        listMatkul.get(0).addTugas( "Teruskan Aplikasi HomeWrecker",
                "Implementasikan semua mockup dan passing data ke activity/fragment baru",
                "20/04/2021",
                "23:59");

        listMatkul.get(0).addTugas( "Edankeun bos HomeWrecker",
                "Implementasikan semua mockup dan passing data ke activity/fragment baru",
                "20/04/2021",
                "23:59");

        listMatkul.get(2).addTugas("Class Diagram",
                "dari source code ATM smt3 jadiin class diagram",
                "17/04/2021",
                "17:00");

        listMatkul.get(3).addTugas("Presentasi ke Telkom",
                "dari dokumen yang telah diisi jadikan ppt kemudian presentasi besok jam 8.40",
                "14/04/2021",
                "23:59");
    }


    protected MatkulDatabase(Parcel in) {
        listMatkul = in.createTypedArrayList(MataKuliah.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(listMatkul);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MatkulDatabase> CREATOR = new Creator<MatkulDatabase>() {
        @Override
        public MatkulDatabase createFromParcel(Parcel in) {
            return new MatkulDatabase(in);
        }

        @Override
        public MatkulDatabase[] newArray(int size) {
            return new MatkulDatabase[size];
        }
    };

    public ArrayList<MataKuliah> getListMatkul() {
        return this.listMatkul;
    }

    public void addMatkul(String fullName, String shortName) {
        this.listMatkul.add(new MataKuliah(fullName, shortName));
    }
}
