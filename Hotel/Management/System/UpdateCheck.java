package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    UpdateCheck(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-In Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel id = new JLabel("ID: ");
        id.setBounds(25,88,46,16);
        id.setFont(new Font("Tahoma", Font.PLAIN, 20));
        id.setForeground(Color.WHITE);
        panel.add(id);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,20);
        panel.add(choice);

        try{
            Con c = new Con();
            ResultSet resultset = c.statement.executeQuery("select * from customer");
            while (resultset.next()){
                choice.add(resultset.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel roomno = new JLabel("Room No.");
        roomno.setBounds(25,129,107,16);
        roomno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        roomno.setForeground(Color.WHITE);
        panel.add(roomno);
        JTextField room_text = new JTextField();
        room_text.setBounds(248,129,140,20);
        panel.add(room_text);

        JLabel name = new JLabel("Name : ");
        name.setBounds(25,173,107,16);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        name.setForeground(Color.WHITE);
        panel.add(name);
        JTextField name_text = new JTextField();
        name_text.setBounds(248,173,140,20);
        panel.add(name_text);

        JLabel checkin = new JLabel("Checked-In : ");
        checkin.setBounds(25,217,140,16);
        checkin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkin.setForeground(Color.WHITE);
        panel.add(checkin);
        JTextField checkin_text = new JTextField();
        checkin_text.setBounds(248,217,140,20);
        panel.add(checkin_text);

        JLabel amt_paid = new JLabel("Amount Paid: ");
        amt_paid.setBounds(25,261,140,16);
        amt_paid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        amt_paid.setForeground(Color.WHITE);
        panel.add(amt_paid);
        JTextField amt_text = new JTextField();
        amt_text.setBounds(248,261,140,20);
        panel.add(amt_text);

        JLabel amt_pend = new JLabel("Amount Pending: ");
        amt_pend.setBounds(25,305,172,20);
        amt_pend.setFont(new Font("Tahoma", Font.PLAIN, 20));
        amt_pend.setForeground(Color.WHITE);
        panel.add(amt_pend);
        JTextField pending_text = new JTextField();
        pending_text.setBounds(248,305,140,20);
        panel.add(pending_text);

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Con C = new Con();
                    String q = choice.getSelectedItem();
                    String room = room_text.getText();
                    String name = name_text.getText();
                    String checkintime = checkin_text.getText();
                    String amount = amt_text.getText();
                    C.statement.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkintime+"', deposit = '"+amount+"' where number = '"+q+"'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from customer where number = '"+id+"'";
                try{
                    Con c = new Con();
                    ResultSet resultset = c.statement.executeQuery(q);

                    while (resultset.next()){
                        room_text.setText(resultset.getString("room"));
                        name_text.setText(resultset.getString("name"));
                        checkin_text.setText(resultset.getString("checkintime"));
                        amt_text.setText(resultset.getString("deposit"));
                    }

                    ResultSet resultset1 = c.statement.executeQuery("select * from room where room_number = '"+room_text.getText()+"'");


                    while (resultset1.next()){
                        String price = resultset1.getString("price");
                        int amountpaid = Integer.parseInt(price) - Integer.parseInt(amt_text.getText());
                        pending_text.setText(""+amountpaid);
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

//        setVisible(true);
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
