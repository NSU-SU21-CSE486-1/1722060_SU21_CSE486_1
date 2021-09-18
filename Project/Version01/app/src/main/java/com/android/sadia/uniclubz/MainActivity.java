package com.android.sadia.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = findViewById(R.id.sign_up);
        signup.setOnClickListener(this);
    }

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.sign_up:
                    startActivity(new Intent(this,SignupActivity.class));
                    break;
            }

        }
} 