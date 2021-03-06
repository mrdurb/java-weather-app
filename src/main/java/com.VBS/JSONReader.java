package com.VBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONReader {

    final String API_KEY = "c0fec04d26bd988c59b99eef68703ba3";
    public String city, weather;
    public int temp, tempMin, tempMax,
                windSpeed, windDeg;

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    public void getData(String city) throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric");

        temp = json.getJSONObject("main").getInt("temp");
        tempMin = json.getJSONObject("main").getInt("temp_min");
        tempMax = json.getJSONObject("main").getInt("temp_max");

        weather = json.getJSONArray("weather").getJSONObject(0).getString("main");

        windSpeed = json.getJSONObject("wind").getInt("speed");
        windDeg = json.getJSONObject("wind").getInt("deg");
    }

}
