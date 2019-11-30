package com.VBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WeatherUI extends JFrame {
    public JLabel jLabel = new JLabel();
    static Image weatherImage = Toolkit.getDefaultToolkit().createImage("src/main/gifs/usualy.gif");
    public JButton switchgif = new JButton("switch");
    public ImageIcon imageIcon = new ImageIcon(weatherImage);
    MyTF townfield = new MyTF();
    MyPaneText currentWeather = new MyPaneText("28",30,60);
    MyPaneText minmaxTemp = new MyPaneText("10",0,20);
    MyPaneText windDegSpeed = new MyPaneText("0",0,20);
    JSONReader data = new JSONReader();
    Weather wt = null;
    public void setGif(String weather)
    {
        weatherImage = Toolkit.getDefaultToolkit().createImage("src/main/gifs/"+weather+".gif");
        ImageIcon img = new ImageIcon(weatherImage);
        img.setImageObserver(jLabel);
        jLabel.setIcon(img);
        jLabel.revalidate();
    }
    public void setColor(Color cl)
    {
        townfield.setForeground(cl);
        minmaxTemp.setForeground(cl);
        currentWeather.setForeground(cl);
        windDegSpeed.setForeground(cl);

    }
    public void getWeatherData(String temp,String minTemp, String maxTemp,String windSpeed, String windDeg,String weather)
    {
        switch(weather)
        {
            case "rain":{
                setColor(Color.white);
                setGif(weather);
                break;
            }
            case "snow":{
                setColor(Color.black);
                setGif(weather);
                break;
            }
            default: {
                setColor(Color.white);
                setGif("usualy");
                break;
            }
        }
        currentWeather.text = temp;
        minmaxTemp.text = "Min : "+minTemp+" Max : "+maxTemp;
        windDegSpeed.text = "Wind speed : "+windSpeed+" Direction : "+windDeg;
    }
    public WeatherUI()
    {
        switchgif.setSize(100,100);
        switchgif.setLocation(100,100);

        //townfield
        townfield.setSize(225,25);
        townfield.setLocation(100,300);
        townfield.setBackground(new Color(0,0,0,50));
        townfield.setForeground(Color.white);

        //current
        currentWeather.setSize(100,100);
        currentWeather.setLocation(170,100);
        currentWeather.setBackground(new Color(0,0,0,0));
        currentWeather.setFont(new Font("TimesRoman",Font.PLAIN,36));
        //minmaxTemp
        minmaxTemp.setSize(100,40);
        minmaxTemp.setLocation(170,200);
        minmaxTemp.setBackground(new Color(0,0,0,0));
        minmaxTemp.setFont(new Font("TimesRoman",Font.PLAIN,20));
        //windDegSpeed
        windDegSpeed.setSize(100,40);
        windDegSpeed.setLocation(170,240);
        windDegSpeed.setBackground(new Color(0,0,0,0));
        windDegSpeed.setFont(new Font("TimesRoman",Font.PLAIN,20));


        townfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data.getData(townfield.getText());
                    wt = new Weather(data);
                    getWeatherData(wt.getTemp(),wt.getTempMin(),wt.getTempMax(),wt.getWindSpeed(),wt.getWindDeg(),wt.getWeather());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        switchgif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weatherImage = Toolkit.getDefaultToolkit().createImage("src/main/gifs/snow.gif");
                ImageIcon img = new ImageIcon(weatherImage);
                img.setImageObserver(jLabel);
                jLabel.setIcon(img);
                jLabel.revalidate();
            }
        });
        imageIcon.setImageObserver(jLabel);
        jLabel.setIcon(imageIcon);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Weather app");
        this.setSize(450,600);
        this.setLocationRelativeTo(null);
        this.add(jLabel);
        this.setContentPane(jLabel);
        this.getContentPane().add(currentWeather);
        this.getContentPane().add(minmaxTemp);
        this.getContentPane().add(windDegSpeed);
      //  this.getContentPane().add(switchgif);
        this.getContentPane().add(townfield);
        this.setVisible(true);
    }

}
class MyTF extends JTextField {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        getRootPane().repaint();
    }
}
class MyPaneText extends JPanel
{
    public String text;
    public int x;
    public int y;

    public MyPaneText(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        getRootPane().repaint();
        g.drawString(text,x,y);
    }
}
