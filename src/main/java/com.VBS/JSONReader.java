package com.VBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=c0fec04d26bd988c59b99eef68703ba3");
        System.out.println(json.toString());
        System.out.println(json.get("id"));

        int pageName = json.getJSONObject("main").getInt("temp");

        JSONArray arr = json.getJSONArray("weather");
        String post_id;
        for (int i = 0; i < arr.length(); i++)
        {
            post_id = arr.getJSONObject(i).getString("description");
            System.out.println("post_id: " + post_id);
        }
        System.out.println("pageName: " + pageName);
    }

}
