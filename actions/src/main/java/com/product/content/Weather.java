package com.product.content;

import com.google.gson.Gson;
import com.product.models.weather.WeatherObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class Weather extends JFrame {

    private static JButton getWeatherButton = new JButton("Get weather");
    private static JTextArea locationInput = new JTextArea(1,5);
    private static JLabel inputLabel = new JLabel("Input location: ");
    private static JTextArea weatherResult = new JTextArea(3,20);
    private static JLabel weatherResultLabel = new JLabel("Weather is: ");

    //constructor
    Weather (String title) {

        super(title);
        setLayout(new BorderLayout());
        weatherResult.setEnabled(false);
        weatherResult.setBackground(Color.GRAY);
        weatherResult.setForeground(Color.GRAY);

        JScrollPane scrollPanel = new JScrollPane(weatherResult);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputLabel);
        inputPanel.add(locationInput);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(weatherResultLabel);
        resultPanel.add(scrollPanel);

        JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new FlowLayout());
        requestPanel.add(getWeatherButton);

        Container container = getContentPane();
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(resultPanel, BorderLayout.CENTER);
        container.add(requestPanel, BorderLayout.SOUTH);

        Weather.getWeatherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Gson gson = new Gson();
                HttpClient httpClient = new HttpClient();
                GetMethod getMethod = new GetMethod("http://api.openweathermap.org/data/2.5/weather?q=" + locationInput.getText() + "&units=metric&APPID=05c28fa7eb244b48dbd7b32cc8163352");

                try {
                    int response = httpClient.executeMethod(getMethod);
                    WeatherObject weatherObject = gson.fromJson(getMethod.getResponseBodyAsString(), WeatherObject.class);
                    if(response == 200)
                        weatherResult.setText("Weather in " + weatherObject.getName()
                                + " is: " + weatherObject.getWeather().get(0).getMain()
                                + " meaning " + weatherObject.getWeather().get(0).getDescription()
                                + " with a temperature of " + weatherObject.getMain().getTemp()
                                + " degrees Celsius and a humidity of " + weatherObject.getMain().getHumidity()
                                + ". The wind speed is " + weatherObject.getWind().getSpeed());
                    else
                        weatherResult.setText("Unable to get weather");
                } catch (HttpException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}

