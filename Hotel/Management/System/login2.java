package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login2 extends JFrame implements ActionListener {

    JTextField textfield1;
    JPasswordField passwordField1;
    JButton b1, b2;

    login2() {
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 55, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.white);
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 105, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.white);
        add(label2);

        textfield1 = new JTextField();
        textfield1.setBounds(150, 55, 150, 30);
        textfield1.setForeground(Color.WHITE);
        textfield1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textfield1.setBackground(new Color(26, 104, 110));
        add(textfield1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 105, 150, 30);
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setBackground(new Color(26, 104, 110));
        add(passwordField1);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
        Image i1 = imageicon.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageicon);
        label.setBounds(325, -30, 280, 320);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 160, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 160, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(3, 45, 48));
        setLayout(null);
        setSize(620, 330);
        setVisible(true);
        setLocation(400, 270);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // Action for Login button
            try{
                Con c = new Con();
                String user = textfield1.getText();
                String pass = passwordField1.getText();

                String q = "select * from login2 where user_name = '"+user+"' and password = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    new admin();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }


        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login2();
    }
}