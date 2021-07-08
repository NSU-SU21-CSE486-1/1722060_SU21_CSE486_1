package com.android.sadia.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
        TextView scroll_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        scroll_textView = (TextView) findViewById(R.id.scroll_text);
         switch(intent.getStringExtra( MainActivity.CASES)){

             case "A":
                 scroll_textView.setText(R.string.lorem1) ;
                 break;

             case "B":
                 scroll_textView.setText(R.string.lorem2) ;
                 break;

             case "C":
                 scroll_textView. setText(R.string.lorem3) ;
                 break;

             default:
                 throw new IllegalStateException("Unexpected value: " + intent.getStringExtra(MainActivity.CASES));
         }
    }
}