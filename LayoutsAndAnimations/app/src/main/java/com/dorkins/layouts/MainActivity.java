package com.dorkins.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fade(View view) {

        ImageView bart = findViewById(R.id.bart);
        ImageView homer = findViewById(R.id.homer);

        bart.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
//        bart.animate().rotation(360).setDuration(2000);
//        bart.animate().translationXBy(1000).setDuration(2000);
//        bart.animate().alpha(0).setDuration(2000);
//        homer.animate().alpha(1).setDuration(2000);
    }
}