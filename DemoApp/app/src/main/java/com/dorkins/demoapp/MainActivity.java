package com.dorkins.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logInWithCredidentials(View view) {


        EditText myUsername = findViewById(R.id.myUsername);
        EditText myPassword = findViewById(R.id.myPassword);
        ImageView preLoginPic = findViewById(R.id.preLoginPic);

        String userName = myUsername.getText().toString();
        String password = myPassword.getText().toString();

        Log.i("Details:", "Username: " + userName + ", Password: " + password);

        if (userName.length() > 1 && password.length() > 1) {
            Toast.makeText(MainActivity.this, userName + " logged in", Toast.LENGTH_SHORT).show();
            preLoginPic.setImageResource(R.drawable.owl2);
        }
    }
}
