package com.android.sadia.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(intent);
    }

    public void launchSecondActivityThree(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
    }

    public void launchSecondActivityTwo(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void launchSecondActivityOne(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}