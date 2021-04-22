package com.example.homewrecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MatkulDatabase matkulDatabase;
    private ArrayList<TugasDatabase> listTugas;

    // fragment
    private ImageButton addButton, notificationButton, allTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data
        matkulDatabase = new MatkulDatabase();
        listTugas = new ArrayList<>();
        getDataTugas(matkulDatabase);

        // put listTugas tu bundle
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("dataTugas", (ArrayList<? extends Parcelable>) listTugas);
        Fragment notifFragment = new NotificationFragment();

        if (notifFragment != null) {
            notifFragment.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container, notifFragment);
            ft.commit();
        }

        // layout inflater
        addButton = findViewById(R.id.addButton);
        notificationButton = findViewById(R.id.notificationButton);
        allTaskButton = findViewById(R.id.allTaskButton);

    }

    @Override
    protected void onResume() {

        super.onResume();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // put matkulDatabase to intent
                Intent intent = new Intent(MainActivity.this, AddMatkulAndTugasActivity.class);
                intent.putExtra("dataMatkul", matkulDatabase.getListMatkul());

                startActivity(intent);
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // put listTugas tu bundle
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("dataTugas", (ArrayList<? extends Parcelable>) listTugas);
                Fragment notifFragment = new NotificationFragment();

                if (notifFragment != null) {
                    notifFragment.setArguments(bundle);
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, notifFragment);
                    ft.commit();
                }
            }
        });

        allTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new AllTaskFragment());
                ft.commit();
            }
        });
    }

    private void getDataTugas(MatkulDatabase matkulDatabase) {
        for (MataKuliah m : matkulDatabase.getListMatkul()) {

            for (Tugas t : m.getListTugas()) {
                listTugas.add(new TugasDatabase(m.getFullName(),
                        m.getShortName(),
                        t.getName(),
                        t.getDescription(),
                        t.getDueDate(),
                        t.getDueTime(),
                        t.getCondition()));
            }
        }
    }
}