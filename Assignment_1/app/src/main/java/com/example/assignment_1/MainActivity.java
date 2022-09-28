package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Initiate global input variables
    RadioGroup groupSize;
    CheckBox check1, check2;
    Button next_Activity;
    Spinner spinner;
    EditText Name,Address,Phone,Message;
    double ExtraCost,SizeCost,ToppingCost = 0;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=10;i<300;i=+10) {
                    progressBar.incrementProgressBy(i);
                    SystemClock.sleep(500);
                }
            }
        });

        progressBar.setVisibility(View.VISIBLE);
        thread.start();


        //Define variables to palette button id's
        check1 = findViewById(R.id.checkBox1);
        check2 = findViewById(R.id.checkBox2);
        spinner = (Spinner) findViewById(R.id.spinner1);
        next_Activity = (Button) findViewById(R.id.button1);
        Name = findViewById(R.id.textName1);
        Address = findViewById(R.id.textAddress1);
        Phone = findViewById(R.id.textPhone1);
        Message = findViewById(R.id.textMessage1);
        groupSize = findViewById(R.id.radioGroup);


        //See which size user has chosen
        groupSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton1:
                        SizeCost = 0;
                        SizeCost = 5.5;
                        break;
                    case R.id.radioButton2:
                        SizeCost = 0;
                        SizeCost = 7.99;
                        break;
                    case R.id.radioButton3:
                        SizeCost = 0;
                        SizeCost = 9.5;
                        break;
                    case R.id.radioButton4:
                        SizeCost = 0;
                        SizeCost = 11.38;
                        break;
                    default:
                        break;
                }
            }
        });

        //Checkbox for extra cheese
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ExtraCost += 5;
                }else{
                    ExtraCost -= 5;
                }
            }
        });

        //checkbox for delivery
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ExtraCost += 5;
                }else{
                    ExtraCost -= 5;
                }
            }
        });

        //When submit button is clicked it will take you to next activity
        next_Activity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                String NameField = Name.getText().toString();
                String AddressField = Address.getText().toString();
                String PhoneField = Phone.getText().toString();
                String MessageField = Message.getText().toString();
                String CostField = Double.toString(ExtraCost + SizeCost + ToppingCost);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("keyName",NameField);
                intent.putExtra("keyAddress",AddressField);
                intent.putExtra("keyPhone",PhoneField);
                intent.putExtra("keyMessage",MessageField);
                intent.putExtra("keyTotalPrice",CostField);

                startActivity(intent);
            }
        });

        //Create array to hold toppings
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.toppings_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    //for dropdown...
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String toppingSelected = spinner.getItemAtPosition(position).toString();
        switch(position){
            case 0:
                ToppingCost = 0;
                ToppingCost = 5;
                break;
            case 1:
                ToppingCost = 0;
                ToppingCost = 5;
                break;
            case 2:
                ToppingCost = 0;
                ToppingCost = 7;
                break;
            case 3:
                ToppingCost = 0;
                ToppingCost = 8;
                break;
            case 4:
                ToppingCost = 0;
                ToppingCost = 10;
                break;
            case 5:
                ToppingCost = 0;
                ToppingCost = 5;
                break;
            case 6:
                ToppingCost = 0;
                ToppingCost = 9;
                break;
            case 7:
                ToppingCost = 0;
                ToppingCost = 5;
                break;
            case 8:
                ToppingCost = 0;
                ToppingCost = 5;
                break;
            case 9:
                ToppingCost = 0;
                ToppingCost = 8;
                break;
            default:
                break;
        }

        Toast.makeText(MainActivity.this,"you selected:" + toppingSelected,Toast.LENGTH_LONG).show();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}