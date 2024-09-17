package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JTextField t1, t2;

    JComboBox combobox, c1, c2;

    JButton add, back;
    AddRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel room_no = new JLabel("ROOM NUMBER");
        room_no.setBounds(60, 60, 150, 27);
        room_no.setForeground(Color.white);
        room_no.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(room_no);
        t1 = new JTextField();
        t1.setBounds(250, 60, 150,27);
        t1.setBackground(new Color(16, 108, 115));
        t1.setFont(new Font("Tahoma", Font.BOLD, 14));
        t1.setForeground(Color.WHITE);
        panel.add(t1);


        JLabel availability = new JLabel("AVAILABILITY");
        availability.setBounds(60, 120, 150,27);
        availability.setForeground(Color.white);
        availability.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(availability);
        combobox = new JComboBox(new String[] {"Available", "Occupied"});
        combobox.setBounds(250, 120, 150, 27);
        combobox.setForeground(Color.WHITE);
        combobox.setBackground(new Color(16, 108, 115));
        combobox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(combobox);

        JLabel price = new JLabel("PRICE");
        price.setBounds(60,180,150,27);
        price.setFont(new Font("serif", Font.BOLD, 17));
        price.setForeground(Color.WHITE);
        panel.add(price);
        t2 = new JTextField();
        t2.setBounds(250, 180, 150,27);
        t2.setForeground(Color.white);
        t2.setBackground(new Color(16,108,115));
        t2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(t2);

        JLabel cleaning = new JLabel("CLEANING STATUS");
        cleaning.setBounds(60, 240, 170,27);
        cleaning.setForeground(Color.WHITE);
        cleaning.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(cleaning);
        c1 = new JComboBox(new String[] {"Cleaning", "Dirty"});
        c1.setBounds(250,240,150,27);
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(16,108,115));
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(c1);

        JLabel bed_type = new JLabel("BED TYPE");
        bed_type.setBounds(60,300,150,27);
        bed_type.setForeground(Color.white);
        bed_type.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(bed_type);
        c2 = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        c2.setBounds(250,300,150,27);
        c2.setForeground(Color.WHITE);
        c2.setBackground(new Color(16,108,115));
        c2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(c2);

        JLabel AED = new JLabel("ADD ROOM DETAILS");
        AED.setBounds(450, 24, 445, 35);
        AED.setFont(new Font("Tahoma", Font.BOLD, 31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        add = new JButton("ADD");
        add.setBounds(60, 380, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(250, 380, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/roomser.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(885, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            try {
                Con c = new Con();
                String room = t1.getText();
                String ava = (String) combobox.getSelectedItem();
                String status = (String) c1.getSelectedItem();
                String price = (String) t2.getText();
                String type = (String) c2.getSelectedItem();

                String q = "insert into room values('"+room+"', '"+ava+"', '"+status+"', '"+price+"', '"+type+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Room Successfully Added");
                this.setVisible(false);


            }catch (Exception E){
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
