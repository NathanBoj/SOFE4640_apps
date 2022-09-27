package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button next_Activity;
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    String[] toppings = {"Mushroom +$5","Dried Tomatoes +$5","Chicken +$7","Ground Beef +$8","Shrimps +$10","Pineapple +$5","Steak +$9","Avocado +$5","Tuna +$5","Broccoli +$2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter AA = new ArrayAdapter(this, android.R.layout.simple_spinner_item,toppings);
        AA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(AA);

        next_Activity = (Button) findViewById(R.id.button1);

        next_Activity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            startActivity(intent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}