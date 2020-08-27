package com.abrar.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

//
//public class Weather extends AsyncTask<String, Void, String> {
//    String result;
//    @Override
//    protected String doInBackground(String... urls) {
//        result= "";
//        URL link;
//        HttpURLConnection myConnection = null;
//
//        try{
//            link = new URL(urls[0]);
//            myConnection = (HttpURLConnection)link.openConnection();
//            InputStream in = myConnection.getInputStream();
//            InputStreamReader myStreamReader = new InputStreamReader(in);
//            int data = myStreamReader.read();
//            while(data!=-1){
//                char current = (char)data;
//                result+=current;
//                data = myStreamReader.read();
//            }
//            return result;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(String s){
//        super.onPostExecute(s);
//        try{
//            JSONObject myObject = new JSONObject(result);
//            JSONObject main = new JSONObject(myObject.getString("main"));
//            String placeName = myObject.getString("name");
//            String temperature = myObject.getString("temp");
//            MainActivity.place.setText(placeName);
//            MainActivity.temp.setText(temperature);
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//    }
//}
public class Weather extends AsyncTask<String,Void,String> {

    String result;
    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myconnection = null;

        try {
            link = new URL(urls[0]);
            myconnection = (HttpURLConnection)link.openConnection();
            InputStream in = myconnection.getInputStream();
            InputStreamReader myStreamReader = new InputStreamReader(in);
            int data = myStreamReader.read();
            while(data!= -1){
                char current = (char)data;
                result+= current;
                data = myStreamReader.read();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject myObject = new JSONObject(result);
            JSONObject city = new JSONObject(myObject.getString("city"));
            String cityName = city.getString("name");
            String lon = city.getString("lon");
            JSONArray list = myObject.getJSONArray("list");
            MainActivity.place.setText(cityName);
            MainActivity.temp.setText(lon);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}