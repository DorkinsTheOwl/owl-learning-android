package com.dorkins.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randNum = rand.nextInt(20) + 1;
    }

    public void guessInputNumber(View view) {
        EditText inputNumber = findViewById(R.id.inputNumber);
        int inputNum = Integer.parseInt(inputNumber.getText().toString());
        String result;

        result = checkNumber(inputNum);

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    public String checkNumber(int n) {

        if (n == randNum) {
            Random rand = new Random();
            randNum = rand.nextInt(20) + 1;
            return "You guessed it.";
        } else if (n > randNum) {
            return "Lower";
        } else {
            return "Higher";
        }
    }
}
