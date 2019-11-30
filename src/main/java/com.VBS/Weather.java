package com.VBS;

public class Weather implements IWeather {

    private String city, weather;
    private int temp, tempMin, tempMax,
                windSpeed, windDeg;
    JSONReader data = new JSONReader();

    public Weather(String city, String weather,
                   int temp, int tempMin, int tempMax,
                   int windSpeed, int windDeg) {
        this.city = city;
        this.weather = weather;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }

    public String getCity() {
        return city;
    }

    public void setCity() {
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather() {
    }

    public String getTemp() {
        return temp + "C";
    }

    public void setTemp() {
    }

    public String getTempMin() {
        return tempMin + "C";
    }

    public void setTempMin() {
    }

    public String getTempMax() {
        return tempMax + "C";
    }

    public void setTempMax() {
    }

    public String getWindSpeed() {
        return windSpeed + "m/s";
    }

    public void setWindSpeed() {
    }

    public String getWindDeg() {
        return null;
    }

    public void setWindDeg() {
    }
}
