package com.example.app.numgenerator;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    public static final String EXTRA_RANGE = "com.example.myfirstapp.RANGE";
    public static final String EXTRA_NUMS = "com.example.myfirstapp.NUMS";
    public static final String EXTRA_SETS = "com.example.myfirstapp.SETS";

    public EditText range;
    public EditText nums;
    public EditText sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        range = findViewById(R.id.Range);
        sets = findViewById(R.id.NumOfSets);
        nums = findViewById(R.id.NumsQuantity);
    }

    public void keyboardHide(View view) throws NullPointerException {
        InputMethodManager m  = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        view = this.getCurrentFocus();
        if(view == null){
            view = new View(this);
        }
        m.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void onClick(View view){
        Intent intent = new Intent(Home.this, Output.class);
        intent.putExtra(EXTRA_SETS, sets.getText().toString());
        intent.putExtra(EXTRA_NUMS, nums.getText().toString());
        intent.putExtra(EXTRA_RANGE, range.getText().toString());
        startActivity(intent);

        range.setText(null);
        nums.setText(null);
        sets.setText(null);
    }
}