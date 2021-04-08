package com.example.homewrecker;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    private ArrayList<Tugas> listTugas;
    private RecyclerView recyclerView;
    private TugasAdapter tugasAdapter;


    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        listTugas = new ArrayList<>();

        getDataTugas();

        recyclerView = view.findViewById(R.id.tugasRecycleView);
        recyclerView.setHasFixedSize(true);
        tugasAdapter = new TugasAdapter(listTugas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tugasAdapter);

        return view;
    }

    private void getDataTugas() {
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