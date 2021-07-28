package com.android.sadia.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);

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

        Intent intent4 = getIntent();
        String university_message = intent4.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView4 = findViewById(R.id.university_field);
        textView4.setText(name_message);

        Intent intent5 = getIntent();
        String department_message = intent5.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView5 = findViewById(R.id.department_field);
        textView5.setText(dob_message);

        Intent intent6 = getIntent();
        String student_id_message = intent6.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView6 = findViewById(R.id.student_id_field);
        textView6.setText(nid_message);

        Intent intent7 = getIntent();
        String study_level_message = intent7.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView7 = findViewById(R.id.study_level_field);
        textView7.setText(blood_group_message);
    }
}