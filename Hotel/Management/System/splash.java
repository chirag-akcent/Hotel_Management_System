package Hotel.Management.System;

import javax.swing.*;

public class splash extends JFrame {

    splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/splash.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,858,680);
        add(label);

        setLayout(null);
        setSize(858, 680);
        setLocation(350, 70);
        setVisible(true);

        try{
            Thread.sleep(3000);
            new login();
            setVisible(false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new splash();
    }
}