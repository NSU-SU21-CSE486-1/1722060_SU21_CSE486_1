package com.android.sadia.Project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UniversityAffiliation extends AppCompatActivity {

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


    public EditText uniNameEditText;
    public EditText departmentEditText;
    public EditText studentIdEditText;
    public EditText studyLevelEditText;

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

        uniNameEditText = findViewById(R.id.input_university_name);
        departmentEditText = findViewById(R.id.input_department);
        studentIdEditText = findViewById(R.id.input_student_id);
        studyLevelEditText = findViewById(R.id.input_study_level);

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


        uniName_message = uniNameEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE4, uniName_message);
        startActivity(intent);

        department_message = departmentEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE5, department_message);
        startActivity(intent);

        studentId_message = studentIdEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE6, studentId_message);
        startActivity(intent);

        studyLevel_message = studyLevelEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE7, studyLevel_message);
        startActivity(intent);

    }
}