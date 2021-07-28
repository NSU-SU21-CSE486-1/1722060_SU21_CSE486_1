package com.android.sadia.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UniversityAffiliation extends AppCompatActivity {

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
    }
}