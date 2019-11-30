package com.VBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherUI extends JFrame {
    public JLabel jLabel = new JLabel();
    static Image weatherImage = Toolkit.getDefaultToolkit().createImage("src/main/gifs/rain.gif");
    public JButton switchgif = new JButton("switch");
    public ImageIcon imageIcon = new ImageIcon(weatherImage);
    MyTF townfield = new MyTF();
    MyPaneText myPaneText = new MyPaneText("text",10,10);
    public WeatherUI()
    {
        switchgif.setSize(100,100);
        switchgif.setLocation(100,100);
        townfield.setSize(225,25);
        townfield.setLocation(100,300);
        townfield.setBackground(new Color(0,0,0,50));
        townfield.setForeground(Color.white);
        myPaneText.setSize(100,100);
        myPaneText.setLocation(100,100);
        myPaneText.setBackground(new Color(0,0,0,50));
        townfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(WeatherUI.this,townfield.getText());
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
        this.getContentPane().add(myPaneText);
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
