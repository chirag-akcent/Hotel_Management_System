package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    Employee(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1150,540);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,1140,400);
        table.setBackground(new Color(4,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Con c= new Con();
            String EmployeeInfo = "select * from employee";
            ResultSet resultset = c.statement.executeQuery(EmployeeInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultset));
            panel.add(table);
        }catch (Exception e){
            e.printStackTrace();
        }

//        JButton button = new JButton("Back");
//        button.setBounds(350,500,120,30);
//        button.setBackground(Color.BLACK);
//        button.setForeground(Color.WHITE);
//        panel.add(button);

        JButton back = new JButton("Back");
        back.setBounds(500,475,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(45,11,70,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(190,11,105,20);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(330,11,105,20);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(480,11,105,20);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(610,11,105,20);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(750,11,105,20);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(phone);

        JLabel email = new JLabel("Email");
        email.setBounds(900,11,105,20);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(email);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(1020,11,105,20);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahomoa", Font.BOLD, 14));
        panel.add(aadhar);

        setUndecorated(true);
        setLocation(250,150);
        setLayout(null);
        setSize(1150,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee();
    }
}
