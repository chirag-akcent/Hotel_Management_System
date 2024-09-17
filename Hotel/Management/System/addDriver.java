package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDriver extends JFrame implements ActionListener {

    JTextField name_text, age_text,car_text,car_text1,location1;

    public JButton add, back;

    JComboBox comboBox,comboBox1;

    addDriver(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(194, 10, 200, 22);
        label.setFont(new Font("serif", Font.BOLD, 22));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel name = new JLabel("NAME");
        name.setBounds(64, 70, 102, 22);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        name_text = new JTextField();
        name_text.setBounds(174, 70, 156, 20);
        name_text.setBackground(new Color(16, 108, 115));
        name_text.setFont(new Font("Tahoma", Font.BOLD, 14));
        name_text.setForeground(Color.WHITE);
        panel.add(name_text);

        JLabel age = new JLabel("AGE");
        age.setBounds(64, 110, 102, 22);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        age.setForeground(Color.WHITE);
        panel.add(age);

        age_text = new JTextField();
        age_text.setBounds(174, 110, 156, 20);
        age_text.setBackground(new Color(16, 108, 115));
        age_text.setFont(new Font("Tahoma", Font.BOLD, 14));
        age_text.setForeground(Color.WHITE);
        panel.add(age_text);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64, 150, 102, 22);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        comboBox = new JComboBox(new String[]{"Male","Female"});
        comboBox.setBounds(176,150,154,20);
        comboBox.setBackground(new Color(16, 108, 115));
        comboBox.setFont(new Font("Italics", Font.BOLD, 14));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel carC = new JLabel("CAR COMPANY");
        carC.setBounds(64, 190, 110, 22);
        carC.setFont(new Font("Tahoma", Font.BOLD, 14));
        carC.setForeground(Color.WHITE);
        panel.add(carC);

        car_text = new JTextField();
        car_text.setBounds(174, 190, 156, 20);
        car_text.setBackground(new Color(16, 108, 115));
        car_text.setFont(new Font("Tahoma", Font.BOLD, 14));
        car_text.setForeground(Color.WHITE);
        panel.add(car_text);

        JLabel carN = new JLabel("CAR NAME");
        carN.setBounds(64, 230, 102, 22);
        carN.setFont(new Font("Tahoma", Font.BOLD, 14));
        carN.setForeground(Color.WHITE);
        panel.add(carN);

        car_text1 = new JTextField();
        car_text1.setBounds(174, 230, 156, 20);
        car_text1.setBackground(new Color(16, 108, 115));
        car_text1.setFont(new Font("Tahoma", Font.BOLD, 14));
        car_text1.setForeground(Color.WHITE);
        panel.add(car_text1);

        JLabel available = new JLabel("Available");
        available.setBounds(64, 270, 102, 22);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        comboBox1 = new JComboBox(new String[]{"Available","Not Available"});
        comboBox1.setBounds(176,270,154,20);
        comboBox1.setBackground(new Color(16, 108, 115));
        comboBox1.setFont(new Font("Italics", Font.BOLD, 14));
        comboBox1.setForeground(Color.white);
        panel.add(comboBox1);

        JLabel location = new JLabel("LOCATION");
        location.setBounds(64, 310, 102, 22);
        location.setFont(new Font("Tahoma", Font.BOLD, 14));
        location.setForeground(Color.WHITE);
        panel.add(location);

        location1 = new JTextField();
        location1.setBounds(174, 310, 156, 20);
        location1.setBackground(new Color(16, 108, 115));
        location1.setFont(new Font("Tahoma", Font.BOLD, 14));
        location1.setForeground(Color.WHITE);
        panel.add(location1);

        add = new JButton("ADD");
        add.setBounds(64, 380, 111, 33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(198, 380, 111, 33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/license.png"));
        Image image1 = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500, 60, 300, 300);
        panel.add(label1);

        setUndecorated(true);
        setLocation(20,200);
        setSize(900,500);
        setVisible(true);
        setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        JComboBox comboBox = new JComboBox();

        if(e.getSource()==add){
            String name = name_text.getText();
            String age = age_text.getText();
            String gender;
            gender = (String) comboBox.getSelectedItem();
            String company = car_text.getText();
            String carname = car_text1.getText();
            String available;
            available = (String) comboBox1.getSelectedItem();
            String location = location1.getText();
            try{
                Con c = new Con();
                String q = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+carname+"', '"+available+"', '"+location+"')";
                c.statement.executeUpdate(q);
//                new JOptionPane(null,1);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                setVisible(false);
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false );
        }
    }

    public static void main(String[] args) {
        new addDriver();

    }
}