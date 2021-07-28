package com.android.sadia.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.android.sadia.project01.extra.MESSAGE";
    private EditText nameEditText;
    private EditText dobEditText;
    private EditText nidEditText;
    private EditText bloodGroupEditText;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.input_name);
        dobEditText = findViewById(R.id.input_DoB);
        nidEditText = findViewById(R.id.input_NID);
        bloodGroupEditText = findViewById(R.id.input_blood_group);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dobEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        dobEditText.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

    public void launchUniversityAffiliation(View view) {
        Intent intent = new Intent(this, UniversityAffiliation.class);
        String name_message = nameEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, name_message);
        startActivity(intent);

        String dob_message = dobEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, dob_message);
        startActivity(intent);

        String nid_message = nidEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, nid_message);
        startActivity(intent);

        String bloodGroup_message = bloodGroupEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, bloodGroup_message);
        startActivity(intent);

    }
}