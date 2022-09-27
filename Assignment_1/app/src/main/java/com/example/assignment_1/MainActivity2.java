package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button previous_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        previous_Activity = (Button) findViewById(R.id.button2);

        previous_Activity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);

            startActivity(intent);
        });
    }
}