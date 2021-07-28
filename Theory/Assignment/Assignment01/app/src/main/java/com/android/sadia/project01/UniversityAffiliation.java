package com.android.sadia.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UniversityAffiliation extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.android.sadia.project01.extra.MESSAGE";

    private EditText uniNameEditText;
    private EditText departmentEditText;
    private EditText studentIdEditText;
    private EditText studyLevelEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_affiliation);

        Intent intent = getIntent();
        String name_message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.name_field);
        textView.setText(name_message);

        Intent intent1 = getIntent();
        String dob_message = intent1.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView1 = findViewById(R.id.dob_field);
        textView1.setText(dob_message);

        Intent intent2 = getIntent();
        String nid_message = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView2 = findViewById(R.id.nid_field);
        textView2.setText(nid_message);

        Intent intent3 = getIntent();
        String blood_group_message = intent3.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView3 = findViewById(R.id.blood_group_field);
        textView3.setText(blood_group_message);

        uniNameEditText = findViewById(R.id.input_university_name);
        departmentEditText = findViewById(R.id.input_department);
        studentIdEditText = findViewById(R.id.input_student_id);
        studyLevelEditText = findViewById(R.id.input_study_level);
    }

    public void launchStudentInformation(View view) {
        Intent intent = new Intent(this, StudentInformation.class);
        String uniName_message = uniNameEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, uniName_message);
        startActivity(intent);

        String department_message = departmentEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, department_message);
        startActivity(intent);

        String studentId_message = studentIdEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, studentId_message);
        startActivity(intent);

        String studyLevel_message = studyLevelEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, studyLevel_message);
        startActivity(intent);

    }
}