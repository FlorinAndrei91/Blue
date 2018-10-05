package com.product.content;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//just a test class
public class UserInterface {

    protected void createWindow() {

        //Create and set up the window
        final JFrame frame = new JFrame("simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel("Im cool", SwingConstants.CENTER);

        JButton b1 = new JButton("Test Button");
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

        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.getContentPane().add(b1, BorderLayout.NORTH);
        //Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }


}