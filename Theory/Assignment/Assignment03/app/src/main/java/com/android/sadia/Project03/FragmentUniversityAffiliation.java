package com.android.sadia.Project03;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


public class FragmentUniversityAffiliation extends Fragment implements AdapterView.OnItemSelectedListener {
    private UniCluBzListViewModel viewModel;

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
    private Context context;

    public FragmentUniversityAffiliation() {

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
        void onInputFUASend(CharSequence input);
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
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(context,
                R.array.university, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (uniNameEditText != null) {
            uniNameEditText.setAdapter(adapter1);
        }


        departmentEditText = v.findViewById(R.id.spinner_department);
        if (departmentEditText != null) {
            departmentEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context,
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
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(context,
                R.array.study_level, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (studyLevelEditText != null) {
            studyLevelEditText.setAdapter(adapter3);
        }

        emailEditText = v.findViewById(R.id.input_email);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //viewModel.setText(emailEditText.getText());

                /*CharSequence input = (CharSequence) uniNameEditText.getSelectedItem().toString();
                listener.onInputFUASend(input);
                CharSequence input1 = (CharSequence) departmentEditText.getSelectedItem().toString();
                listener.onInputFUASend(input1);
                CharSequence input2 = studentIdEditText.getText();
                listener.onInputFUASend(input2);
                CharSequence input3 = (CharSequence) studyLevelEditText.getSelectedItem().toString();
                listener.onInputFUASend(input3);
                CharSequence input4 = emailEditTex*/
            }

        });
        return v;
    }


    /*public void updateUniNameEditText(ArrayAdapter<CharSequence> Adapter1) {
        uniNameEditText.setAdapter(Adapter1);
    }

    public void updateDepartmentEditText(ArrayAdapter<CharSequence> Adapter2) {
        departmentEditText.setAdapter(Adapter2);
    }

    public void updateStudentIdEditText(CharSequence newText1) {
        studentIdEditText.setText(newText1);
    }

    public void updateStudyLevelEditText(ArrayAdapter<CharSequence> Adapter3) {
        studyLevelEditText.setAdapter(Adapter3);
    }

    public void updateEmailEditText(CharSequence newText2) {
        emailEditText.setText(newText2);
    }*/


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentUniversityAffiliationListener){
            listener = (FragmentUniversityAffiliationListener) context;
        }
        else{
            throw new RuntimeException(context.toString() +
                    "You Need to Implement FragmentUniversityAffiliationListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
