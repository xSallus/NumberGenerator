package com.example.app.numgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFormatException;
import android.widget.LinearLayout;

import java.text.ParseException;

import regradenegocio.NGenerator;

public class Output extends AppCompatActivity {
    LinearLayout out = findViewById(R.id.output);
    NGenerator generator;
    String range;
    String nums;
    String sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            range = extras.getString("range");
            nums = extras.getString("nums");
            sets = extras.getString("sets");
        }
    }

    public void handleData() {
        //the data received from previous view will be treated here...
    }
}
