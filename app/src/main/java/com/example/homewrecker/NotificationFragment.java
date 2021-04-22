package com.example.homewrecker;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    //private MatkulDatabase listMataKuliah;
    private ArrayList<TugasDatabase> listTugas;
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

        // get listTugas
        if (savedInstanceState != null) {
            savedInstanceState = getArguments();
            listTugas = savedInstanceState.getParcelableArrayList("data");
            Log.e("Frag_a:savedInstance", listTugas.toString());
        }
        else {
            Log.e("Frag_a:null", "Frag_a:null");
            Bundle bundle = getArguments();
            listTugas = bundle.getParcelableArrayList("dataTugas");
        }

        // recycler view //
        recyclerView = view.findViewById(R.id.tugasRecycleView);
        recyclerView.setHasFixedSize(true);
        tugasAdapter = new TugasAdapter(listTugas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tugasAdapter);

        return view;
    }

}