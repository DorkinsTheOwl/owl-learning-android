package com.dorkins.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);

        final ArrayList<String> shoppingList = new ArrayList<>();

        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Cheese");
        shoppingList.add("Eggs");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shoppingList);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("Person tapped: ", shoppingList.get(position));
                Toast.makeText(getApplicationContext(), "Item: " + shoppingList.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
