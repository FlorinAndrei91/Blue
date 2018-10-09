package com.product.content;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//just a test class
public class UserInterface {

    //main window(frame)
    void createWindow() {
        //Create and set up the window
        final JFrame frame = new JFrame("Test GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel("Good day to you :)", SwingConstants.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton b1 = new JButton("Test Button");
        secondaryFrame(b1, frame);

        JButton b2 = new JButton("Calculator");
        calculator(b2, frame);

        JButton b3 = new JButton("Get Weather");
        getWeather(b3, frame);


        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        //Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    //secondary frame - when "Test Button" button is pressed
    private void secondaryFrame(JButton b1, final JFrame frame) {

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JLabel innerTextLabel = new JLabel("World", SwingConstants.CENTER);
                innerTextLabel.setPreferredSize(new Dimension(300, 100));
                // display/center the jdialog when the button is pressed
                JFrame d = new JFrame("Hello");
                d.setPreferredSize(new Dimension(300, 100));
                d.getContentPane().add(innerTextLabel, BorderLayout.CENTER);
                d.setLocationRelativeTo(frame);
                d.pack();
                d.setVisible(true);
            }
        });

    }

    //secondary frame - when "Calculator" button is pressed
    private void calculator(JButton button, final JFrame frame) {

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame calculator = new Calculator("Calculator");
                calculator.setPreferredSize(new Dimension(350, 150));
                calculator.setLocationRelativeTo(frame);
                calculator.pack();
                calculator.setVisible(true);
            }
        });
    }

    private void getWeather(JButton button, final JFrame frame) {

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame weather = new Weather("Get Weather");
                weather.setPreferredSize(new Dimension(350, 150));
                weather.setLocationRelativeTo(frame);
                weather.pack();
                weather.setVisible(true);
            }
        });
    }


}