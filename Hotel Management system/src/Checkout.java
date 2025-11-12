package hotel.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.Date;
import java.sql.ResultSet;
import java.util.Date;


public class Checkout extends JFrame implements ActionListener {

    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;

    Checkout() {

        setLayout(null);

        // adding label //
        JLabel text = new JLabel("CHECKOUT");
        text.setBounds(130,20,140,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(190, 80, 150, 25);
        add(ccustomer);



//-----------------------------------------------------------------------------------------------------------------//
        // adding image //
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
//        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel tick = new JLabel(i3);
//        tick.setBounds(300, 80, 20, 20);
//        add(tick);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

         lblroomnumber = new JLabel();
        lblroomnumber.setBounds(255,130,70,30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Check In Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

         lblcheckintime = new JLabel();
        lblcheckintime.setBounds(190,180,170,30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Check Out Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);


        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(190,230,170,30);
        add(lblcheckouttime);

        checkout = new JButton("Checkout");
        checkout.setBounds(30,300,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(190,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try {
            // creating conn //
            conn c = new conn();

            // Use executeQuery() for SELECT queries
            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // adding image //
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(380, 50, 400, 250);
        add(image);

//-----------------------------------------------------------------------------------------------------------------//

        // to get the frame //
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,800,400);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = "DELETE FROM customer WHERE number = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "UPDATE room SET availability = 'Available' WHERE roomnumber = '" + lblroomnumber.getText() + "'";

            try {
                conn c = new conn();
                c.s.executeUpdate(query1);  // Use the variable without quotes
                c.s.executeUpdate(query2);  // Use the variable without quotes

                JOptionPane.showMessageDialog(null, "Checkout Done");

                setVisible(false);
                new hotel.management.system.Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            setVisible(false);
            new hotel.management.system.Reception();

        }

    }

    public static void main(String[] args) {

        new Checkout();
    }
}
