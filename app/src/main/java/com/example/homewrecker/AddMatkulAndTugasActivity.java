package com.example.homewrecker;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class AddMatkulAndTugasActivity extends AppCompatActivity {
    private ArrayList<MataKuliah> listMatkul;
    //fragment
    private Button tambahMatkulButton, tambahTugasButton;

    // header
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_matkul_and_tugas);

        listMatkul = getIntent().getParcelableArrayListExtra("dataMatkul");

        // Fragment
        replaceFragment(new AddMatkulFragment());

        // layout inflater
        tambahMatkulButton = findViewById(R.id.tambahMatkulButton);
        tambahTugasButton = findViewById(R.id.tambahTugasButton);
        backButton = findViewById(R.id.backButton);
    }

    @Override
    public void onResume() {
        super.onResume();
        tambahMatkulButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // put listMatkul to bundle
                replaceFragment(new AddMatkulFragment());

            }
        });

        tambahTugasButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // put listMatkul tu bundle
                replaceFragment(new AddTugasFragment());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("dataMatkul", (ArrayList<? extends Parcelable>)listMatkul);

        if(fragment != null) {
            fragment.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.containerAdd, fragment);
            ft.commit();
        }
    }
}