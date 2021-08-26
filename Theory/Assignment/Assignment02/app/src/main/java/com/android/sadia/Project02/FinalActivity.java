package com.android.sadia.Project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    public String name_message;
    public String dob_message;
    public String nid_message;
    public String bloodGroup_message;
    public String department_message;
    public String studentId_message;
    public String studyLevel_message;
    public String uniName_message;
    public String email_message;
    public String phone_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


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

        Intent intent4 = getIntent();
        uniName_message = intent4.getStringExtra(UniversityAffiliation.EXTRA_MESSAGE4);
        TextView textView4 = findViewById(R.id.university_field);
        textView4.setText(uniName_message);

        Intent intent5 = getIntent();
        department_message = intent5.getStringExtra(UniversityAffiliation.EXTRA_MESSAGE5);
        TextView textView5 = findViewById(R.id.department_field);
        textView5.setText(department_message);

        Intent intent6 = getIntent();
        studentId_message  = intent6.getStringExtra(UniversityAffiliation.EXTRA_MESSAGE6);
        TextView textView6 = findViewById(R.id.student_id_field);
        textView6.setText(studentId_message );

        Intent intent7 = getIntent();
        studyLevel_message = intent7.getStringExtra(UniversityAffiliation.EXTRA_MESSAGE7);
        TextView textView7 = findViewById(R.id.study_level_field);
        textView7.setText(studyLevel_message);

        Intent intent8 = getIntent();
        email_message = intent8.getStringExtra(SecondActivity.EXTRA_MESSAGE8);
        TextView textView8 = findViewById(R.id.email_address_field);
        textView8.setText(email_message);

        Intent intent9 = getIntent();
        phone_message = intent9.getStringExtra(SecondActivity.EXTRA_MESSAGE9);
        TextView textView9 = findViewById(R.id.phone_number_field);
        textView9.setText(phone_message);

    }
}
