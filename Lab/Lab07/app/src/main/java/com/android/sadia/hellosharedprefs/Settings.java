package com.android.sadia.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class Settings extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private EditText countEntry;


    // Key for current count
    public final String COUNT_KEY = "count";
    // Key for current color
    public final String COLOR_KEY = "color";

    public TextView mShowCountTextView;

    public SharedPreferences mPreferences;
    public SharedPreferences.Editor preferencesEditor;
    private String sharedPrefFile = "com.example.android.hellosharedprefs";

    //public SwitchMaterial switch1;
    //public SwitchMaterial switch2;

    private String color;
    public static final String LAST_COUNT = "last count";
    public static final int RESULT_RESET = -20;

    //CORRECT_COUNT --> LAST_COUNT

    private ArrayList<String> options = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        options.add("Default");
        options.add("Black");
        options.add("Red");
        options.add("Blue");
        options.add("Green");

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        preferencesEditor = mPreferences.edit();

        countEntry = findViewById(R.id.count_edit_text);
        spinner = findViewById(R.id.color_spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        color = options.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        color = "Default";

    }

    public void reset(View view){
        setResult(RESULT_RESET, new Intent());
        finish();
    }

    public void save(View view) {
        Intent intent = new Intent();
        intent.putExtra(COLOR_KEY, color);

        String temp = countEntry.getText().toString();

        if (!temp.equals("")){
            intent.putExtra(COUNT_KEY, Integer.parseInt(temp));
            intent.putExtra(LAST_COUNT, true);
        }
        else{
            intent.putExtra(LAST_COUNT, false);
        }
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
    }
}