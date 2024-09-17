package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,150,30);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel customerid = new JLabel("Customer-ID");
        customerid.setBounds(30,80,100,30);
        customerid.setFont(new Font("Tahoma", Font.BOLD, 14));
        customerid.setForeground(Color.WHITE);
        panel.add(customerid);

        Choice Customer = new Choice();
        Customer.setBounds(200,80,220,25);
        panel.add(Customer);

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(30,130,120,30);
        roomno.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomno.setForeground(Color.WHITE);
        panel.add(roomno);

        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200,130,100,30);
        labelRoomnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoomnumber.setForeground(Color.WHITE);
        panel.add(labelRoomnumber);

        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30,180,120,30);
        checkintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,220,30);
        labelcheckintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-out Time");
        checkouttime.setBounds(30,230,120,30);
        checkouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                Customer.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Con cv = new Con();
                    cv.statement.executeUpdate("delete from customer where number = '"+Customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set availability = 'Available' where room_number = '"+labelRoomnumber.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }catch (Exception E){

                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Con c = new Con();
                try{
                    ResultSet resultset = c.statement.executeQuery("select * from customer where number = '"+Customer.getSelectedItem()+"' ");
                    while (resultset.next()) {
                        labelRoomnumber.setText(resultset.getString("room"));
                        labelcheckintime.setText(resultset.getString("checkintime"));
                    }
                }catch (Exception E){

                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        Date date = new Date();

        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,220,30);
        labelcheckouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);

        setUndecorated(true);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
        setLayout(null);
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}