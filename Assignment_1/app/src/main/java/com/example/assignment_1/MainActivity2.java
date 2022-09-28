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
    TextView Name,Address,Phone,Message,Price;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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

        String NameField = getIntent().getStringExtra("keyName");
        String AddressField = getIntent().getStringExtra("keyAddress");
        String PhoneField = getIntent().getStringExtra("keyPhone");
        String MessageField = getIntent().getStringExtra("keyMessage");
        String PriceField = getIntent().getStringExtra("keyTotalPrice");

        Name = findViewById(R.id.textName2);
        Address = findViewById(R.id.textAddress2);
        Phone = findViewById(R.id.textPhone2);
        Message = findViewById(R.id.textMessage2);
        Price = findViewById(R.id.textPrice2);

        Name.setText(NameField);
        Address.setText(AddressField);
        Phone.setText(PhoneField);
        Message.setText(MessageField);
        Price.setText(PriceField);

        previous_Activity = (Button) findViewById(R.id.button2);

        previous_Activity.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View V) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}