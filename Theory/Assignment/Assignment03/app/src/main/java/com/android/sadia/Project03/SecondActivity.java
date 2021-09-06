package com.android.sadia.Project03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

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
    public static final String EXTRA_MESSAGE8 =
            "com.android.sadia.project01.extra.MESSAGE8";
    public static final String EXTRA_MESSAGE9 =
            "com.android.sadia.project01.extra.MESSAGE9";

    private EditText emailEditText;
    private EditText phoneEditText;

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
        setContentView(R.layout.activity_second);

        emailEditText = findViewById(R.id.input_email);
        phoneEditText= findViewById(R.id.input_phone);

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
    }


    public void launchFinalActivity(View view) {
        Intent intent = new Intent(this, FinalActivity.class);

        intent.putExtra(EXTRA_MESSAGE, name_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE1, dob_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE2, nid_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE3, bloodGroup_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE4, uniName_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE5, department_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE6, studentId_message);
        startActivity(intent);


        intent.putExtra(EXTRA_MESSAGE7, studyLevel_message);
        startActivity(intent);

        email_message = emailEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE8, email_message);
        startActivity(intent);


        phone_message = phoneEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE9, phone_message);
        startActivity(intent);

    }
}