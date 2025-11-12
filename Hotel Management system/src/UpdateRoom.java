package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom  extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
    JButton check,update,back;

    UpdateRoom () {

        setLayout (null);


        // adding label //
        JLabel text = new JLabel("Update Room status");
        text.setBounds(30, 20, 250, 30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setForeground(Color.BLACK);
        add(text);


        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            // creating conn //
            conn c = new conn();

            // Use executeQuery() for SELECT queries
            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // adding label //
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);


        // adding label //
        JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30, 180, 100, 20);
        add(lblname);

        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        // adding label //
        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30, 230, 100, 20);
        add(lblcheckin);

        tfstatus = new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);


        check = new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        // adding image icon //

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

//--------------------------------------------------------------------------------------------------------------//
        // creating frame to be diplayed //
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,980,450);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        // for check button //

        if (ae.getSource() == check) {

            String id =  ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()) {
                    tfroom.setText(rs.getString("room"));

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");

                while(rs2.next()) {

                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // for update button //

        } else if (ae.getSource() == update) {

            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();


            try {

                conn c = new conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"' ");

                JOptionPane.showMessageDialog(null,"Data Has Been Updated");

                setVisible(false);
                new hotel.management.system.Reception();


            } catch (Exception e) {
                e.printStackTrace();
            }

            // for back button //
        } else {

            setVisible(false);
            new hotel.management.system.Reception();

        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }

}
