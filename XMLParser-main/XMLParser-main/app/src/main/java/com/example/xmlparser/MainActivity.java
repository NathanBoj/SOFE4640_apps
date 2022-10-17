package com.example.xmlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XmlResourceParser parser = getResources().getXml(R.xml.weather);
        try {
            processData(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    private void processData(XmlResourceParser parser) throws XmlPullParserException {
        int eventType = -1;
        eventType = parser.getEventType();

        String city,temperature,weather;

        while(eventType != XmlResourceParser.END_DOCUMENT) {
            if (eventType == XmlResourceParser.START_TAG) {
                String localName = parser.getName();
                if (localName.equals("location")) {
                    city = parser.getAttributeValue(null, "city");
                    temperature = parser.getAttributeValue(null, "temperature");
                    weather = parser.getAttributeValue(null, "weather");
//                    Log.d("testParser", city + " " + temperature + " " + weather);
                    printValues(city,temperature,weather);
                }

            }


            try {
                eventType = parser.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private void printValues(String city, String temperature, String weather){
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        TextView cityText = new TextView(this);
        TextView temperatureText = new TextView(this);
        TextView weatherText = new TextView(this);
        LinearLayout linearLayout1 = findViewById(R.id.linearLayoutParser);

        cityText.setLayoutParams(params);
        cityText.setText(city);
        cityText.setTextColor(Color.RED);
        cityText.setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);


        temperatureText.setLayoutParams(params);
        temperatureText.setText(temperature);
        temperatureText.setTextColor(Color.BLUE);
        temperatureText.setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);

        weatherText.setLayoutParams(params);
        weatherText.setText(weather);
        weatherText.setTextColor(Color.rgb(100,100,100));
        weatherText.setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);

        linearLayout.addView(cityText);
        linearLayout.addView(temperatureText);
        linearLayout.addView(weatherText);
        linearLayout1.addView(linearLayout);
    }
}