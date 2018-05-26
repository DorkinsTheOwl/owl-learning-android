package com.example.tsokolovs.md2;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner medikamenti, kategorija;
    TextView izvade;
    TextInputEditText vecums, svars;
    Button aprekinat;
    int kategorijasVertiba, medikamentuVertiba, svarsVertiba, vecumsVertiba, rezultats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medikamenti = findViewById(R.id.medikamenti);
        kategorija = findViewById(R.id.kategorija);
        izvade = findViewById(R.id.izvade);
        vecums = findViewById(R.id.vecumsIevade);
        svars = findViewById(R.id.svarsIevade);

        final String ANTIBIOTIKAS = getString(R.string.antibiotikas_label);
        final String PROFILAKSEI = getString(R.string.profilakse_label);

        final MyArrayAdaptor medikamentiAntibiotikas = MyArrayAdaptor.createFromResource(
                this, R.array.medikamenti_antibiotikas_arr,
                android.R.layout.simple_spinner_item);
        final MyArrayAdaptor medikamentiProfilaksei = MyArrayAdaptor.createFromResource(
                this, R.array.medikamenti_profilaksei_arr,
                android.R.layout.simple_spinner_item);
        final MyArrayAdaptor kategorijaAdapter = MyArrayAdaptor.createFromResource(
                this, R.array.kategorija_arr, android.R.layout.simple_spinner_item);
        final MyArrayAdaptor blankAdapter = MyArrayAdaptor.createFromResource(
                this, R.array.blank_arr, android.R.layout.simple_spinner_item);

        kategorijaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medikamentiAntibiotikas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medikamentiProfilaksei.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        kategorija.setAdapter(kategorijaAdapter);
        medikamenti.setAdapter(blankAdapter);

        kategorija.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getSelectedItem().toString();
                if (selectedItem.equals(ANTIBIOTIKAS)) {
                    medikamenti.setAdapter(medikamentiAntibiotikas);
                } else if (selectedItem.equals(PROFILAKSEI)) {
                    medikamenti.setAdapter(medikamentiProfilaksei);
                } else {
                    medikamenti.setAdapter(blankAdapter);
                }
                kategorijasVertiba = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                medikamenti.setAdapter(blankAdapter);
            }
        });

        medikamenti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                medikamentuVertiba = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void aprekinatDevu(View view) {
        if (vecums.getText().toString().equals("")) {
            vecumsVertiba = 0;
        } else {
            vecumsVertiba = Integer.parseInt(vecums.getText().toString());
        }

        if (svars.getText().toString().equals("")) {
            svarsVertiba = 0;
        } else {
            svarsVertiba = Integer.parseInt(svars.getText().toString());
        }

        if (kategorijasVertiba == 0) {
            izvade.setText("Izvelieties kategoriju");
        } else if (medikamentuVertiba == 0) {
            izvade.setText("Izvelieties medikamentu");
        } else if (vecumsVertiba == 0) {
            izvade.setText("Vecums nedrikst but 0");
        } else if (svarsVertiba == 0) {
            izvade.setText("Svars nedrikst but 0");
        } else {
            rezultats = (kategorijasVertiba + medikamentuVertiba) * vecumsVertiba + svarsVertiba;
            izvade.setText("Deva: " + Integer.toString(rezultats));
            rezultats = 0;
        }
    }
}
