package com.VBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherUI extends JFrame {
    public JLabel jLabel = new JLabel();
    static Image weatherImage = Toolkit.getDefaultToolkit().createImage("src/gifs/rain.gif");
    public JButton switchgif = new JButton("switch");
    public ImageIcon imageIcon = new ImageIcon(weatherImage);
    public WeatherUI()
    {
        switchgif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weatherImage = Toolkit.getDefaultToolkit().createImage("src/gifs/snow.gif");
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
        this.getContentPane().add(switchgif,BorderLayout.SOUTH);
        this.setVisible(true);
    }

}
