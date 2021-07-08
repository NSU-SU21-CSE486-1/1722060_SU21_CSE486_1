package com.android.sadia.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public Intent intent;
    public static final String CASES =
            "com.android.sadia.twoactivities.CASES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SecondActivity.class);
    }

    public void launchSecondActivityOne(View view) {
        intent.putExtra("CASES","A");
        startActivity(intent);
    }

    public void launchSecondActivityThree(View view) {
        intent.putExtra ("CASES","C");
        startActivity(intent);
    }

    public void launchSecondActivityTwo(View view) {
        intent = this.intent.putExtra("CASES", "B");
        startActivity(this.intent);

    }
}