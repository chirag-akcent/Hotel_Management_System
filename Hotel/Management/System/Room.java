package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame{

    JTable table;

    JButton back;

    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,165,200,200);
        panel.add(label);

        JLabel room = new JLabel("Room No.");
        room.setBounds(12,110,80,19);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel ava = new JLabel("Available");
        ava.setBounds(120,110,80,19);
        ava.setForeground(Color.WHITE);
        ava.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(ava);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(210,110,150,19);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(320,110,150,19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel bed_type = new JLabel("Bed Type");
        bed_type.setBounds(420,110,150,19);
        bed_type.setForeground(Color.WHITE);
        bed_type.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bed_type);

        table = new JTable();
        table.setBounds(10,140,500,350);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con c = new Con();
                String roominfo = "select * from room";
                ResultSet resultset = c.statement.executeQuery(roominfo);
                table.setModel(DbUtils.resultSetToTableModel(resultset));

        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Room();
    }
}
