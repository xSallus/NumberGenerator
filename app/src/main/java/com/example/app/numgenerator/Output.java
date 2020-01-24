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
    public String range;
    public String nums;
    public String sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent intent = getIntent();
        sets = intent.getStringExtra(Home.EXTRA_SETS);
        nums = intent.getStringExtra(Home.EXTRA_NUMS);
        range = intent.getStringExtra(Home.EXTRA_RANGE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.85), (int)(height*0.85));

        for (int k=0; k<Integer.parseInt(sets); k++) {

            generator = new NGenerator(Integer.parseInt(nums),Integer.parseInt(range));

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