package com.example.app.numgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import regradenegocio.NGenerator;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

public class Output extends AppCompatActivity {
    public LinearLayout outputs;
    public NGenerator generator;
    public Integer range;
    public Integer nums;
    public Integer sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent intent = getIntent();
        sets = intent.getIntExtra(Home.EXTRA_SETS, 0);
        nums = intent.getIntExtra(Home.EXTRA_NUMS, 0);
        range = intent.getIntExtra(Home.EXTRA_RANGE, 0);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.85), (int)(height*0.85));

        for (int k=0; k<sets; k++) {

            generator = new NGenerator(nums,range);

            outputs = findViewById(R.id.output);
            TextView textView = new TextView(this);
            textView.setText(generator.toString());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            textView.setLayoutParams(params);
            outputs.addView(textView);
        }
    }
}