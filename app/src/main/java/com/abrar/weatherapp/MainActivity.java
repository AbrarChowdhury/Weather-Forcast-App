package com.abrar.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView place;
    static TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        place =(TextView)findViewById(R.id.place);
        temp = (TextView)findViewById(R.id.temp);

        Weather getData = new Weather();
//        getData.execute("http://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=cfed7c64af95043b841289e62ab1022d");
        getData.execute("https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=cfed7c64af95043b841289e62ab1022d");
        //api.openweathermap.org/data/2.5/weather?lat=23.8103&lon=90.4125&appid=94785620b46305861350a8d4c206fe98
        //api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=94785620b46305861350a8d4c206fe98

    }
}