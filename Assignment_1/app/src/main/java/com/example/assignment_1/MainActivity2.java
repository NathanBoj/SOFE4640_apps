package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //Initiate global input variables
    Button previous_Activity;
    TextView Topping,Name,Address,Phone,Message,Price;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Progress bar just for fun
        bar = findViewById(R.id.progressBar2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<100;i=+1) {
                    bar.incrementProgressBy(i);
                    SystemClock.sleep(100);
                }
            }
        });

        bar.setVisibility(View.VISIBLE);
        thread.start();

        //Here we get the values the user inputted in the first activity using key values
        String ToppingField = getIntent().getStringExtra("keyTopping");
        String NameField = getIntent().getStringExtra("keyName");
        String AddressField = getIntent().getStringExtra("keyAddress");
        String PhoneField = getIntent().getStringExtra("keyPhone");
        String MessageField = getIntent().getStringExtra("keyMessage");
        String PriceField = getIntent().getStringExtra("keyTotalPrice");

        Topping = findViewById(R.id.Topping2);
        Name = findViewById(R.id.textName2);
        Address = findViewById(R.id.textAddress2);
        Phone = findViewById(R.id.textPhone2);
        Message = findViewById(R.id.textMessage2);
        Price = findViewById(R.id.textPrice2);

        //Just set the text to the users information in the first activity
        Topping.setText(ToppingField);
        Name.setText(NameField);
        Address.setText(AddressField);
        Phone.setText(PhoneField);
        Message.setText(MessageField);
        Price.setText(PriceField);

        previous_Activity = (Button) findViewById(R.id.button2);

        //Button that goes back to the first activity
        previous_Activity.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View V) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}