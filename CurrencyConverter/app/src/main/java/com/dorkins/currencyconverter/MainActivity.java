package com.dorkins.currencyconverter;

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

    public void convertToEuros(View view) {

        EditText amountInDollars = findViewById(R.id.amountInDollars);
        double doubleAmount = Double.parseDouble(amountInDollars.getText().toString());
        doubleAmount *= 0.81251;
        String result = String.format("%1.2f", doubleAmount);

        Toast.makeText(MainActivity.this, result + "€", Toast.LENGTH_LONG).show();
    }
}
