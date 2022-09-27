package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView question1;
    Button next_Activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next_Activity_button = (Button) findViewById(R.id.first);
        question1 = (TextView) findViewById(R.id.question1_id);

        question1.setText("Q1 - How to pass the data between activities in Android?\n" + "\n" + "Ans - Intent");

        next_Activity_button.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            startActivity(intent);
        });
    }
}