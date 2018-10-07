package com.product.content;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class that extends JFrame made for calculator
class Calculator extends JFrame {

    private static JButton addButton = new JButton("+");
    private static JButton subtractionsButton = new JButton("-");
    private static JButton multiplicationButton = new JButton("*");
    private static JButton divisionButton = new JButton("/");
    private static JTextArea inputOne = new JTextArea(1,5);
    private static JTextArea inputTwo = new JTextArea(1,5);
    private static JTextArea response = new JTextArea(1,5);
    private static JLabel inputOneLable = new JLabel("First number: ");
    private static JLabel inputTwoLable = new JLabel("Second number: ");
    private static JLabel responseLable = new JLabel("Result: ");

    private double inputOneInt;
    private double inputTwoInt;

    //constructor
    Calculator( String title) {

        //set title
        super(title);
        //set layout
        setLayout(new BorderLayout());
        //make response text area read only
        response.setEnabled(false);
        //set collor for response text area
        response.setBackground(Color.GRAY);
        response.setForeground(Color.GRAY);

        //panel that contains input fields
        JPanel inputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
        inputpanel.add(inputOneLable);
        inputpanel.add(inputOne);
        inputpanel.add(inputTwoLable);
        inputpanel.add(inputTwo);

        //panel that contains output fields
        JPanel outputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
        outputpanel.add(responseLable);
        outputpanel.add(response);

        //panel that contains buttons (operations)
        JPanel operationpanel = new JPanel();
        operationpanel.setLayout(new FlowLayout());
        operationpanel.add(addButton);
        operationpanel.add(subtractionsButton);
        operationpanel.add(multiplicationButton);
        operationpanel.add(divisionButton);

        //add panels to the container
        final Container c = getContentPane();
        c.add(inputpanel, BorderLayout.CENTER);
        c.add(outputpanel, BorderLayout.NORTH);
        c.add(operationpanel, BorderLayout.SOUTH);

        //what happens when addButton is pressed
        Calculator.addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean isException = false;

                    try {
                        inputOneInt = Double.parseDouble(inputOne.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputOne, "first input");
                        isException = true;
                    }

                    try {
                        inputTwoInt = Double.parseDouble(inputTwo.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputTwo, "second input");
                        isException = true;
                    }

                if(!isException) {
                    double result = inputOneInt + inputTwoInt;
                    response.setText(Double.toString(result));
                } else {
                    response.setText("");
                }
                    inputOne.setText("");
                    inputTwo.setText("");

            }
        });

        //what happens when subtractionsButton is pressed
        Calculator.subtractionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean isException = false;

                    try {
                        inputOneInt = Double.parseDouble(inputOne.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputOne, "first input");
                        isException = true;
                    }

                    try {
                        inputTwoInt = Double.parseDouble(inputTwo.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputTwo, "second input");
                        isException = true;
                    }

                    if(!isException) {
                        double result = inputOneInt - inputTwoInt;
                        response.setText(Double.toString(result));
                    } else {
                        response.setText("");
                    }
                    inputOne.setText("");
                    inputTwo.setText("");


            }
        });

        //what happens when multiplicationButton is pressed
        Calculator.multiplicationButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean isException = false;

                    try {
                        inputOneInt = Double.parseDouble(inputOne.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputOne, "first input");
                        isException = true;
                    }

                    try {
                        inputTwoInt = Double.parseDouble(inputTwo.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputTwo, "second input");
                        isException = true;
                    }

                    if(!isException) {
                        double result = inputOneInt * inputTwoInt;
                        response.setText(Double.toString(result));
                    } else {
                        response.setText("");
                    }
                    inputOne.setText("");
                    inputTwo.setText("");


            }
        });

        //what happens when divisionButton is pressed
        Calculator.divisionButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean isException = false;

                    try {
                        inputOneInt = Double.parseDouble(inputOne.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputOne, "first input");
                        isException = true;
                    }

                    try {
                        inputTwoInt = Double.parseDouble(inputTwo.getText());
                    } catch (NumberFormatException ex) {
                        exceptionHandler(c, inputTwo, "second input");
                        isException = true;
                    }

                    if(!isException) {
                        double result = inputOneInt / inputTwoInt;
                        response.setText(Double.toString(result));
                    } else {
                        response.setText("");
                    }
                    inputOne.setText("");
                    inputTwo.setText("");


            }
        });

    }

    //exception handling
    private void exceptionHandler (Container c, JTextArea textArea, String input) {
        JFrame d = new JFrame("Error");
        JLabel innerTextLabel = new JLabel("Invalid value provided for " + input, SwingConstants.CENTER);
        innerTextLabel.setPreferredSize(new Dimension(300, 100));
        d.setPreferredSize(new Dimension(300, 100));
        d.getContentPane().add(innerTextLabel, BorderLayout.CENTER);
        d.setLocationRelativeTo(c);
        d.pack();
        d.setVisible(true);
        textArea.setText("");
    }
}
