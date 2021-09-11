package com.example.user.getmethere;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ByBus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    SqlConnect sql = new SqlConnect(this);
    // Spinner element
    Spinner spinner, spinner2;
    String label;
    // Add button
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_bus);
        loadSpinnerData();
        try {
            SqlConnect.myInput = getAssets().open(SqlConnect.DB_NAME);
            this.sql.createDataBase();
            SqlConnect.openDataBase();

        } catch (IOException localIOException) {
        }
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner_arrival);
        spinner.setOnItemSelectedListener(this);
        List<String> labels = new ArrayList<String>();
        String[] st = {"arrival station"};
        Cursor i = sql.Select_Data("view_buses", st, "departure station" + "=" + label, null, null, null, null);
        if (i.moveToFirst()) {
            do {
                labels.add(i.getString(1));
            } while (i.moveToNext());
        }


        // closing connection
        i.close();


    }

    private void loadSpinnerData() {


        List<String> labels = new ArrayList<String>();
        String[] st = {"departure station"};
        Cursor i = sql.Select_Data("view_buses", st, null, null, null, null, null);
        if (i.moveToFirst()) {
            do {
                labels.add(i.getString(0));
            } while (i.moveToNext());
        }


        // closing connection
        i.close();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels);
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        label = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();


    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
