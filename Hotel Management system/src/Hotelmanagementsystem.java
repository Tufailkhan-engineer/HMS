package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hotelmanagementsystem extends JFrame implements ActionListener {

    Hotelmanagementsystem() {
    setSize(1366,565);
        setLocation(100,100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

JLabel text = new JLabel("Hotel Management System");
text.setBounds(20,430,1000,90);
image.add(text);
text.setForeground(Color.WHITE);
text.setFont(new Font("Serif", Font.PLAIN, 50));

        JLabel text1 = new JLabel("Welcome to Our Hotel");
        text1.setBounds(300,210,1000,90);
        image.add(text1);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Serif", Font.PLAIN, 80));

JButton next = new JButton("Next");
next.setBounds(1150,450,150,50);
image.add(next);
next.setBackground(Color.WHITE);
next.setForeground(Color.BLACK);
next.addActionListener(this);
next.setFont(new Font("Serif", Font.PLAIN, 20));
image.add(next);

        setVisible(true);

}

public void actionPerformed(ActionEvent ae)
{
    setVisible(false);
    new Login();

}

    public static void main(String[] args) {

        new Hotelmanagementsystem();
 }
 }