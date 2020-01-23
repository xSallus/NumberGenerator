package com.example.app.numgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Output extends AppCompatActivity {
    LinearLayout out = findViewById(R.id.output);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
    }

    public void handleData(){
        //the data received from previous view will be treated here...
    }
}
