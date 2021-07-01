package com.example.sadia.happybirthday;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Happy Birthday to Sazia");
        try{}
        catch(Exception e){
            Log.e("MainActivity", "Happy Birthday to Sazia");
        }
    }
}