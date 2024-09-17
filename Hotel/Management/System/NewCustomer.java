package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField name_text, no_text, country_text, dep_text;

    JRadioButton m, f;
    Choice c1;

    JButton back, add;

    JLabel date;

    NewCustomer(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);

        JLabel newcust = new JLabel("NEW CUSTOMER FORM");
        newcust.setBounds(118,11,260,53);
        newcust.setFont(new Font("Tahoma", Font.BOLD, 20));
        newcust.setForeground(Color.WHITE);
        panel.add(newcust);

        JLabel gov = new JLabel("Gov ID :");
        gov.setBounds(35,76,200,14);
        gov.setFont(new Font("Tahoma", Font.BOLD, 14));
        gov.setForeground(Color.WHITE);
        panel.add(gov);

        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter's Id", "Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(comboBox);

        JLabel number = new JLabel("Number");
        number.setBounds(35,111,200,14);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        number.setForeground(Color.WHITE);
        panel.add(number);
        no_text = new JTextField();
        no_text.setBounds(271,111,150,20);
        panel.add(no_text);

        JLabel name = new JLabel("Name");
        name.setBounds(35,151,200,14);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);
        name_text = new JTextField();
        name_text.setBounds(271,151,150,20);
        panel.add(name_text);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(35,191,200,14);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        m = new JRadioButton("Male");
        m.setBounds(271,191,80,12);
        m.setFont(new Font("Tahoma", Font.BOLD, 14));
        m.setForeground(Color.WHITE);
        m.setBackground(new Color(3,45,48));
        panel.add(m);
        f = new JRadioButton("Female");
        f.setBounds(350,191,80,12);
        f.setFont(new Font("Tahoma", Font.BOLD, 14));
        f.setForeground(Color.WHITE);
        f.setBackground(new Color(3,45,48));
        panel.add(f);

        JLabel con = new JLabel("Country");
        con.setBounds(35,231,200,20);
        con.setFont(new Font("Tahoma", Font.BOLD, 14));
        con.setForeground(Color.WHITE);
        panel.add(con);
        country_text = new JTextField();
        country_text.setBounds(271,231,150,20);
        panel.add(country_text);

        JLabel roomno = new JLabel("Allocated Room Number");
        roomno.setBounds(35,274,200,20);
        roomno.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomno.setForeground(Color.WHITE);
        panel.add(roomno);

        c1 = new Choice();
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel checkinSt = new JLabel("Checked-In ");
        checkinSt.setBounds(35,316,200,20);
        checkinSt.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkinSt.setForeground(Color.WHITE);
        panel.add(checkinSt);

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,200,20);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel deposit = new JLabel("Deposits: ");
        deposit.setBounds(35,359,200,20);
        deposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        deposit.setForeground(Color.WHITE);
        panel.add(deposit);
        dep_text = new JTextField();
        dep_text.setBounds(271,359,150,20);
        panel.add(dep_text);

        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setLocation(400,150);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            Con c = new Con();
            String radioBTn = null;
            if(m.isSelected()){
                radioBTn = "Male";
            } else if(f.isSelected()){
                radioBTn = "Female";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = no_text.getText();
            String s3 = name_text.getText();
            String s4 = radioBTn;
            String s5 = country_text.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = dep_text.getText();

            try {
                String q = "insert into customer values('"+s1+"', '"+s3+"', '"+s2+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
                String q1 = "update room set availability = 'Occupied' where room_number = "+s6;

                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Suucessfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
