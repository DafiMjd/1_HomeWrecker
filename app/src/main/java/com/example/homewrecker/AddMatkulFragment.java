package com.example.homewrecker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddMatkulFragment extends Fragment {
    private ArrayList<MataKuliah> listMatkul;

    public AddMatkulFragment() {
        // empty constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_matkul, container, false);

        // get listMatkul
        if (savedInstanceState != null) {
            savedInstanceState = getArguments();
            listMatkul = savedInstanceState.getParcelableArrayList("dataMatkul");
            Log.e("Frag_a:savedInstance", listMatkul.toString());
        }
        else {
            Log.e("Frag_a:null", "Frag_a:null");
            Bundle bundle = getArguments();
            listMatkul = bundle.getParcelableArrayList("dataMatkul");
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void onClick(View view) {
        EditText matkulNameTxt = view.findViewById(R.id.matkulNameTxt);
        EditText matkulSingkatanTxt = view.findViewById(R.id.matkulSingkatanTxt);

        String matkulName = matkulNameTxt.getText().toString();
        String matkulSingkatan = matkulSingkatanTxt.getText().toString();

        if (matkulName!=null && matkulSingkatan!=null) {
            listMatkul.add(new MataKuliah(matkulName, matkulSingkatan));
        }
        else{
            Toast.makeText(getActivity().getApplicationContext(), "Belum Menginput data",Toast.LENGTH_SHORT).show();
        }


    }
}
