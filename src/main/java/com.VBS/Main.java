package com.VBS;

public class Main {

    public static void main(String[] args) {
	    new WeatherUI();
	    JsonReader WeatherInfo = new JsonReader();
	    WeatherInfo.getWeather();
        //System.out.println("Hello World!");
    }
}
