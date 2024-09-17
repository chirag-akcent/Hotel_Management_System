package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField name_text, age_text, salary1, phone1, aadhar1, email1;

    public JRadioButton male, female;

    JComboBox comboBox;

    JButton add, back;

    public AddEmployee() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel name = new JLabel("NAME");
        name.setBounds(60, 40, 150, 27);
        name.setFont(new Font("serif", Font.BOLD, 17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        name_text = new JTextField();
        name_text.setBounds(200, 40, 150, 27);
        name_text.setBackground(new Color(16, 108, 115));
        name_text.setFont(new Font("Tahoma", Font.BOLD, 14));
        name_text.setForeground(Color.WHITE);
        panel.add(name_text);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 150, 27);
        age.setFont(new Font("serif", Font.BOLD, 17));
        age.setForeground(Color.WHITE);
        panel.add(age);
        age_text = new JTextField();
        age_text.setBounds(200, 80, 150, 27);
        age_text.setBackground(new Color(16, 108, 115));
        age_text.setFont(new Font("Tahoma", Font.BOLD, 14));
        age_text.setForeground(Color.WHITE);
        panel.add(age_text);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 120, 150, 27);
        gender.setFont(new Font("serif", Font.BOLD, 17));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        male = new JRadioButton("Male");
        male.setBounds(200, 120, 70, 27);
        male.setBackground(new Color(3, 45, 48));
        male.setFont(new Font("Tahoma", Font.BOLD, 14));
        male.setForeground(Color.WHITE);
        panel.add(male);
        female = new JRadioButton("Female");
        female.setBounds(275, 120, 150, 27);
        female.setBackground(new Color(3, 45, 48));
        female.setFont(new Font("Tahoma", Font.BOLD, 14));
        female.setForeground(Color.WHITE);
        panel.add(female);

        JLabel job = new JLabel("JOB");
        job.setBounds(60, 170, 150, 27);
        job.setFont(new Font("Serif", Font.BOLD, 17));
        job.setForeground(Color.WHITE);
        panel.add(job);
        comboBox = new JComboBox(new String[]{"FrontDesk", "Housekeeping", "Kitchen Staff", "Room Service", "Manager", "Accountant", "Chef", "Security"});
        comboBox.setBackground(new Color(16, 108, 115));
        comboBox.setBounds(200, 170, 150, 30);
        comboBox.setFont(new Font("Italics", Font.BOLD, 14));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 220, 150, 27);
        salary.setFont(new Font("serif", Font.BOLD, 17));
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salary1 = new JTextField();
        salary1.setBounds(200, 220, 150, 27);
        salary1.setBackground(new Color(16, 108, 115));
        salary1.setFont(new Font("Tahoma", Font.BOLD, 14));
        salary1.setForeground(Color.WHITE);
        panel.add(salary1);

        JLabel phone = new JLabel("PHONE NO.");
        phone.setBounds(60, 270, 150, 27);
        phone.setFont(new Font("serif", Font.BOLD, 17));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phone1 = new JTextField();
        phone1.setBounds(200, 270, 150, 27);
        phone1.setBackground(new Color(16, 108, 115));
        phone1.setFont(new Font("Tahoma", Font.BOLD, 14));
        phone1.setForeground(Color.WHITE);
        panel.add(phone1);

        JLabel Aadhar = new JLabel("AADHAR NO.");
        Aadhar.setBounds(60, 320, 150, 27);
        Aadhar.setFont(new Font("serif", Font.BOLD, 17));
        Aadhar.setForeground(Color.WHITE);
        panel.add(Aadhar);
        aadhar1 = new JTextField();
        aadhar1.setBounds(200, 320, 150, 27);
        aadhar1.setBackground(new Color(16, 108, 115));
        aadhar1.setFont(new Font("Tahoma", Font.BOLD, 14));
        aadhar1.setForeground(Color.WHITE);
        panel.add(aadhar1);

        JLabel email = new JLabel("EMAIL ID");
        email.setBounds(60, 370, 150, 27);
        email.setFont(new Font("serif", Font.BOLD, 17));
        email.setForeground(Color.WHITE);
        panel.add(email);
        email1 = new JTextField();
        email1.setBounds(200, 370, 150, 27);
        email1.setBackground(new Color(16, 108, 115));
        email1.setFont(new Font("Tahoma", Font.BOLD, 14));
        email1.setForeground(Color.WHITE);
        panel.add(email1);

        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450, 24, 445, 35);
        AED.setFont(new Font("Tahoma", Font.BOLD, 31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        add = new JButton("Add");
        add.setBounds(60, 420, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(200, 420, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 100, 300, 300);
        panel.add(label);

        setUndecorated(true);
        setLocation(60, 160);
        setLayout(null);
        setSize(900, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            String name = name_text.getText();
            String age = age_text.getText();
            String salary = salary1.getText();
            String phone = phone1.getText();
            String email = email1.getText();
            String aadhar = aadhar1.getText();
            String job = (String) comboBox.getSelectedItem();
            String gender = null;
            if (male.isSelected()) gender = "male";
            else if (female.isSelected()){
                gender = "female";
            }

            try{
                Con c = new Con();
                String q = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee Added successfully");
                setVisible(false);
            }
            catch (Exception E){
                E.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}