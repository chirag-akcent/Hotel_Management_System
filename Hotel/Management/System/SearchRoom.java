package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;

    Choice choice;

    JTable table;

    JButton search, back;

    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel searchforroom = new JLabel("Search For Room");
        searchforroom.setBounds(250,11,186,31);
        searchforroom.setForeground(Color.WHITE);
        searchforroom.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(searchforroom);

        JLabel bed_type = new JLabel("Room Bed Type");
        bed_type.setBounds(40,67,130,25);
        bed_type.setForeground(Color.WHITE);
        bed_type.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(bed_type);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(170,70,120,25);
        panel.add(choice);

        JLabel room_no = new JLabel("Room Number");
        room_no.setBounds(15,132,120,25);
        room_no.setForeground(Color.WHITE);
        room_no.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(room_no);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,132,120,25);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(available);

        JLabel status = new JLabel("Status");
        status.setBounds(320,132,120,25);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(status);

        JLabel price = new JLabel("Price");
        price.setBounds(450,132,120,25);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(price);

        JLabel blabel = new JLabel("Bed Type");
        blabel.setBounds(580,132,120,25);
        blabel.setForeground(Color.WHITE);
        blabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(blabel);

        table = new JTable();
        table.setBounds(0,157,700,230);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Con c = new Con();
            String q = "select * from room";
            ResultSet resultset = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        }catch (Exception E){
            E.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(200,400,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        panel.add(search);

        back = new JButton("Back");
        back.setBounds(380,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,200);
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String Q = "select * from room where bed_type = '"+choice.getSelectedItem()+"'";
            String q = "select * from room where availability = 'Available' And bed_type = '"+choice.getSelectedItem()+"'";
            try{
                Con c = new Con();
                ResultSet resultset = c.statement.executeQuery(Q);
                table.setModel(DbUtils.resultSetToTableModel(resultset));

                if(checkBox.isSelected()){
                    ResultSet resultset1 = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultset1));
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
