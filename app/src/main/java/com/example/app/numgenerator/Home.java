package com.example.app.numgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    EditText range;
    EditText nums;
    EditText sets;

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
        String ranGe = range.getText().toString();
        String nuMs = nums.getText().toString();
        String seTs = sets.getText().toString();

        Intent i = new Intent(getBaseContext(), Output.class);
        startActivity(i);

        range.setText(null);
        nums.setText(null);
        sets.setText(null);
    }
}
