package com.example.homewrecker;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddTugasFragment extends Fragment {
    private ArrayList<MataKuliah> listMatkul;

    private TextInputLayout matkulDropDown;
    private AutoCompleteTextView actMatkul;

    private ArrayAdapter<MataKuliah> arrayAdapterListMatkul;

    public AddTugasFragment() {
        // empty constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

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

        matkulDropDown = view.findViewById(R.id.matkulDropdown);
        actMatkul = view.findViewById(R.id.actMatkul);

        arrayAdapterListMatkul = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.tv_entity, listMatkul);
        actMatkul.setAdapter(arrayAdapterListMatkul);

        actMatkul.setThreshold(1);

        return view;
    }
}
