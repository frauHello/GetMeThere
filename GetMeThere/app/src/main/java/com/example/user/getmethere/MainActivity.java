package com.example.user.getmethere;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    SqlConnect sql = new SqlConnect(this);
    RadioButton radioButton1, radioButton2;
    Boolean train = false, bus = false;
    Button bt;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("inMain", "in main activity");
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        try {
            SqlConnect.myInput = getAssets().open(SqlConnect.DB_NAME);
            this.sql.createDataBase();
            SqlConnect.openDataBase();

        } catch (IOException localIOException) {
        }
        radioButton1 = (RadioButton) findViewById(R.id.db);
        radioButton2 = (RadioButton) findViewById(R.id.dt);
        bt = (Button) findViewById(R.id.getInfo);


    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.db:
                if (checked)
                    bus = true;
                intent = new Intent(this, ByBus.class);
                break;
            case R.id.dt:
                if (checked)
                    train = true;
                intent = new Intent(this, ByTrain.class);
                break;


        }
    }


    public void onButton1(View view) {
        startActivity(intent);


    }
}