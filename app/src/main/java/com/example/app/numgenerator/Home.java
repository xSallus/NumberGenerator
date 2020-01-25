package com.example.app.numgenerator;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    public static final String EXTRA_RANGE = "com.example.app.numgenerator.EXTRA_RANGE";
    public static final String EXTRA_NUMS = "com.example.app.numgenerator.EXTRA_NUMS";
    public static final String EXTRA_SETS = "com.example.app.numgenerator.EXTRA_SETS";

    public EditText range;
    public EditText nums;
    public EditText sets;

    Button draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        range = findViewById(R.id.Range);
        sets = findViewById(R.id.NumOfSets);
        nums = findViewById(R.id.NumsQuantity);

        draw = findViewById(R.id.draw);
        draw.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openOutputs();
            }
        }));
    }

    public void keyboardHide(View view) throws NullPointerException {
        InputMethodManager m  = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        view = this.getCurrentFocus();
        if(view == null){
            view = new View(this);
        }
        m.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void openOutputs() {
        Intent intent = new Intent(Home.this, Output.class);
        intent.putExtra(EXTRA_SETS, Integer.parseInt(sets.getText().toString()));
        intent.putExtra(EXTRA_NUMS, Integer.parseInt(nums.getText().toString()));
        intent.putExtra(EXTRA_RANGE, Integer.parseInt(range.getText().toString()    ));
        startActivity(intent);

        range.setText(null);
        nums.setText(null);
        sets.setText(null);
    }
}