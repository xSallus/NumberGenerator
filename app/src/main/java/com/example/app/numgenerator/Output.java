package com.example.app.numgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

import regradenegocio.NGenerator;

public class Output extends AppCompatActivity {
    LinearLayout outputs;
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
            sets = extras.getString("sets", "0");
            nums = extras.getString("nums", "0");
            range = extras.getString("range", "0");
        }

        generator = new NGenerator(Integer.parseInt(nums),Integer.parseInt(range));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.85), (int)(height*0.85));

        for (int i=0; i<Integer.parseInt(sets); i++) {

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
