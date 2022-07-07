package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    HashMap<String, String> LoginInfo = new HashMap<String, String>();

    JFrame Frame = new JFrame();
    JButton LoginButton = new JButton("Log in");
    JButton ResetButton = new JButton("Reset");
    JTextField UserIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User ID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();

    LoginPage(HashMap<String, String> LoginInfoOrignal) {
        LoginInfo = LoginInfoOrignal;

        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));


        UserIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        LoginButton.setBounds(125, 200, 100, 25);
        LoginButton.addActionListener(this);

        ResetButton.setBounds(225, 200, 100, 25);
        ResetButton.addActionListener(this);

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(UserIDField);
        Frame.add(userPasswordField);
        Frame.add(userIdLabel);
        Frame.add(userPasswordLabel);
        Frame.add(LoginButton);
        Frame.add(ResetButton);
        Frame.add(messageLabel);

        Frame.setSize(420, 420);
        Frame.setLayout(null);
        Frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ResetButton) {
            UserIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == LoginButton){
            String userID = UserIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if (LoginInfo.containsKey(userID)){
                if(LoginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    Frame.dispose();

                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Login Failed!");
                }

            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }

        }

    }
}
