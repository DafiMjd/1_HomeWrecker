package com.example.homewrecker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllTaskFragment extends Fragment {
    private LiveTaskViewModel liveTaskViewModel;

    private RecyclerView recyclerView;
    private LiveTaskAdapter liveTaskAdapter;

    public AllTaskFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_task, container, false);

        //liveTaskViewModel = ViewModelProviders(getActivity()).get(LiveTaskViewModel.class);
        Toast.makeText(getActivity().getApplicationContext(), "onChaged", Toast.LENGTH_SHORT).show();

        System.out.println("this: " + this);
        System.out.println("requireActivity(): " + requireActivity());
        System.out.println("getActivity().getApplication(): " + getActivity().getApplication());
        System.out.println("new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())): " + new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()));

        recyclerView = view.findViewById(R.id.tugasRecycleView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        liveTaskAdapter = new LiveTaskAdapter();

        recyclerView.setAdapter(liveTaskAdapter);

//        liveTaskViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(LiveTaskViewModel.class);
//        liveTaskViewModel.getAllTasks().observe(this, new Observer<ArrayList<LiveTask>>() {
//            @Override
//            public void onChanged(ArrayList<LiveTask> liveTasks) {
//                Toast.makeText(getActivity().getApplicationContext(), "onChaged", Toast.LENGTH_SHORT).show();
//            }
//        });



        return view;
    }
}
