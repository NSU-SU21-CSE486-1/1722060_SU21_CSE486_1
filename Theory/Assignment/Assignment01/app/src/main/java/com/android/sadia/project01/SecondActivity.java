package com.android.sadia.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE8 =
            "com.android.sadia.project01.extra.MESSAGE8";
    public static final String EXTRA_MESSAGE9 =
            "com.android.sadia.project01.extra.MESSAGE9";


    private EditText emailEditText;
    private EditText phoneEditText;
    public String email_message;
    public String phone_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        emailEditText = findViewById(R.id.input_email);
        phoneEditText = findViewById(R.id.input_phone);

    }


    public void launchFinalActivity(View view) {
        Intent intent = new Intent(this, FinalActivity.class);

        email_message = emailEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE8, email_message);
        startActivity(intent);

        phone_message = phoneEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE9, phone_message);
        startActivity(intent);
    }
}