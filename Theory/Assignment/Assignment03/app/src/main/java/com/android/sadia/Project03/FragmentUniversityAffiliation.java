package com.android.sadia.Project03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class FragmentUniversityAffiliation extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner uniNameEditText;
    private Spinner departmentEditText;
    private EditText studentIdEditText;
    private Spinner studyLevelEditText;
    private EditText emailEditText;
    private FragmentUniversityAffiliationListener listener;
    private Button buttonSubmit;




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentUniversityAffiliation() {

    }


    public static FragmentUniversityAffiliation newInstance(String param1, String param2) {
        FragmentUniversityAffiliation fragment = new FragmentUniversityAffiliation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface FragmentUniversityAffiliationListener{
        onInputFUASend(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_university_affiliation, container, false);

        uniNameEditText = v.findViewById(R.id.spinner_university);
        if (uniNameEditText != null) {
            uniNameEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.university, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (uniNameEditText != null) {
            uniNameEditText.setAdapter(adapter1);
        }


        departmentEditText = v.findViewById(R.id.spinner_department);
        if (departmentEditText != null) {
            departmentEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.department, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (departmentEditText != null) {
            departmentEditText.setAdapter(adapter2);
        }

        studentIdEditText = v.findViewById(R.id.input_student_id);

        studyLevelEditText = v.findViewById(R.id.spinner_study_level);
        if (studyLevelEditText != null) {
            studyLevelEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.study_level, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (studyLevelEditText != null) {
            studyLevelEditText.setAdapter(adapter3);
        }

        emailEditText = v.findViewById(R.id.input_email);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
            
        });
        return v;
    }

}
