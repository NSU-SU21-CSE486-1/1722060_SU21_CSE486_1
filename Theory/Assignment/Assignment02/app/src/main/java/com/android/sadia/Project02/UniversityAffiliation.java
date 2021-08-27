package com.android.sadia.Project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UniversityAffiliation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_MESSAGE =
            "com.android.sadia.project01.extra.MESSAGE";
    public static final String EXTRA_MESSAGE1 =
            "com.android.sadia.project01.extra.MESSAGE1";
    public static final String EXTRA_MESSAGE2 =
            "com.android.sadia.project01.extra.MESSAGE2";
    public static final String EXTRA_MESSAGE3 =
            "com.android.sadia.project01.extra.MESSAGE3";
    public static final String EXTRA_MESSAGE4 =
            "com.android.sadia.project01.extra.MESSAGE4";
    public static final String EXTRA_MESSAGE5 =
            "com.android.sadia.project01.extra.MESSAGE5";
    public static final String EXTRA_MESSAGE6 =
            "com.android.sadia.project01.extra.MESSAGE6";
    public static final String EXTRA_MESSAGE7 =
            "com.android.sadia.project01.extra.MESSAGE7";


    public Spinner uniNameEditText;
    public Spinner departmentEditText;
    public EditText studentIdEditText;
    public Spinner studyLevelEditText;

    public String name_message;
    public String dob_message;
    public String nid_message;
    public String bloodGroup_message;
    public String department_message;
    public String studentId_message;
    public String studyLevel_message;
    public String uniName_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_affiliation);


        Intent intent = getIntent();
        name_message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.name_field);
        textView.setText(name_message);

        Intent intent1 = getIntent();
        dob_message = intent1.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        TextView textView1 = findViewById(R.id.dob_field);
        textView1.setText(dob_message);

        Intent intent2 = getIntent();
        nid_message = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        TextView textView2 = findViewById(R.id.nid_field);
        textView2.setText(nid_message);

        Intent intent3 = getIntent();
        bloodGroup_message = intent3.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        TextView textView3 = findViewById(R.id.blood_group_field);
        textView3.setText(bloodGroup_message);

        uniNameEditText = findViewById(R.id.spinner_university);
        if (uniNameEditText != null) {
            uniNameEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.university, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (uniNameEditText != null) {
            uniNameEditText.setAdapter(adapter1);
        }


        departmentEditText = findViewById(R.id.spinner_department);
        if (departmentEditText != null) {
            departmentEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.department, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (departmentEditText != null) {
            departmentEditText.setAdapter(adapter2);
        }

        studentIdEditText = findViewById(R.id.input_student_id);

        studyLevelEditText = findViewById(R.id.spinner_study_level);
        if (studyLevelEditText != null) {
            studyLevelEditText.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.study_level, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (studyLevelEditText != null) {
            studyLevelEditText.setAdapter(adapter3);
        }

    }


    public void launchStudentInformation(View view) {
        Intent intent = new Intent(this, StudentInformation.class);

        intent.putExtra(EXTRA_MESSAGE, name_message);
        startActivity(intent);

        intent.putExtra(EXTRA_MESSAGE1, dob_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE2, nid_message);
        startActivity(intent);

        intent.putExtra(EXTRA_MESSAGE3, bloodGroup_message);
        startActivity(intent);


        uniName_message = uniNameEditText.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE4, uniName_message);
        startActivity(intent);

        department_message = departmentEditText.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE5, department_message);
        startActivity(intent);

        studentId_message = studentIdEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE6, studentId_message);
        startActivity(intent);

        studyLevel_message = studyLevelEditText.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE7, studyLevel_message);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}