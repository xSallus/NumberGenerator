package com.example.app.numgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFormatException;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        TextView setsOutput;

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            range = extras.getString("range");
            nums = extras.getString("nums");
            sets = extras.getString("sets");
        }

        for (int i=0; i<Integer.parseInt(sets); i++) {
            setsOutput = new TextView(this);
            setsOutput.setId(i);
            setsOutput.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            generator = new NGenerator(Integer.parseInt(nums), Integer.parseInt(range));
            setsOutput.setText(generator.toString());
            out.addView(setsOutput);
        }
    }
}
