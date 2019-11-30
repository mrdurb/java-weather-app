package com.VBS;

public class Weather implements IWeather {

    private String city, weather;
    private int temp, tempMin, tempMax,
                windSpeed, windDeg;

    public Weather(JSONReader data) {
        this.city = data.city;
        this.weather = data.weather;
        this.temp = data.temp;
        this.tempMin = data.tempMin;
        this.tempMax = data.tempMax;
        this.windSpeed = data.windSpeed;
        this.windDeg = data.windDeg;
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

        if (windDeg > 340 && windDeg < 25)  return "North";
        if (windDeg > 25  && windDeg < 70)  return "Northwest";
        if (windDeg > 70  && windDeg < 115) return "West";
        if (windDeg > 115 && windDeg < 160) return "Southwest";
        if (windDeg > 160 && windDeg < 205) return "South";
        if (windDeg > 205 && windDeg < 250) return "Southeast";
        if (windDeg > 250 && windDeg < 295) return "East";
        if (windDeg > 295 && windDeg < 340) return "Northeast";

        return "error";
    }

    public void setWindDeg() {
    }
}
