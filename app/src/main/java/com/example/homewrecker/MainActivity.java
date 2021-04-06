package com.example.homewrecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Tugas> listTugas;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.tugasRecycleView);
        listTugas = new ArrayList<>();

        setTugasInfo();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(listTugas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setTugasInfo() {
        listTugas.add(new Tugas (   "PPB",
                                    "Recycle View",
                                    "Implementasikan mock-up dan buat recycle view",
                                    "6/04/2021", "23.59"));
        listTugas.add(new Tugas (   "PPL1",
                                    "UML to Java",
                                    "",
                                    "11/04/2021", "23.59"));
        listTugas.add(new Tugas (   "PPL4(Proyek)",
                                    "IOT",
                                    "topik bentrok dg kelompok lain",
                                    "7/04/2021", "23.59"));
        listTugas.add(new Tugas (   "HIMPUNAN",
                                    "KAK",
                                    "beresin",
                                    "11/04/2021", "23.59"));
        listTugas.add(new Tugas (   "PMW",
                                    "Eksplor Antares",
                                    "",
                                    "13/04/2021", "23.59"));
        listTugas.add(new Tugas (   "Karir",
                                    "Belajara bisnis",
                                    "",
                                    "13/04/2021", "23.59"));
        listTugas.add(new Tugas (   "Pola Hidup",
                                    "Perbaiki pola hidup",
                                    "",
                                    "13/04/2021", "23.59"));
        listTugas.add(new Tugas (   "Pola Hidup",
                "Perbaiki pola hidup",
                "",
                "13/04/2021", "23.59"));
        listTugas.add(new Tugas (   "Pola Hidup",
                "Perbaiki pola hidup",
                "",
                "13/04/2021", "23.59"));
    }


}