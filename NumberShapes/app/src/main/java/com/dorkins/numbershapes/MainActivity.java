package com.dorkins.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkForSquareOrTriangularNumber(View view) {
        EditText inputNumber = findViewById(R.id.inputNumber);
        int number = Integer.parseInt(inputNumber.getText().toString());

        Number myNumber = new Number(number);
        Toast.makeText(MainActivity.this, myNumber.checkNumberShape(), Toast.LENGTH_SHORT).show();

    }
}
