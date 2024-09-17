package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,810,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel pickuo = new JLabel("Pick Up Service");
        pickuo.setBounds(315,11,160,25);
        pickuo.setForeground(Color.WHITE);
        pickuo.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(pickuo);

        JLabel cartype = new JLabel("Car Type");
        cartype.setBounds(39,97,80,19);
        cartype.setForeground(Color.WHITE);
        cartype.setFont(new Font("Tahoma", Font.PLAIN,14));
        panel.add(cartype);

        JTable table = new JTable();
        table.setBounds(5,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Con c1 = new Con();
            String q = "select * from driver";
            ResultSet resultSet = c1.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();

        }

        Choice c = new Choice();
        c.setBounds(123,97,160,25);
        panel.add(c);

        try{
            Con C = new Con();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while(resultSet.next()){
                c.add(resultSet.getString("carname"));

            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(160,208,46,14);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(270,208,46,14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Car Company");
        company.setBounds(360,208,110,14);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel carname = new JLabel("Car Name");
        carname.setBounds(480,208,110,14);
        carname.setForeground(Color.WHITE);
        panel.add(carname);

        JLabel ava = new JLabel("Available");
        ava.setBounds(590,208,110,14);
        ava.setForeground(Color.WHITE);
        panel.add(ava);

        JLabel loc = new JLabel("Location");
        loc.setBounds(710,208,110,14);
        loc.setForeground(Color.WHITE);
        panel.add(loc);

        setLayout(null);
        setSize(820,600);
        setLocation(500,100);
        setVisible(true);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
                try{
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }
    public static void main(String[] args) {
        new PickUp();
    }
}
