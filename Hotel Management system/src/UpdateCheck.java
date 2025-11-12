package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck  extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;

    UpdateCheck () {

        setLayout (null);


        // adding label //
        JLabel text = new JLabel("Update status");
        text.setBounds(100, 20, 200, 30);
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
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);


        // adding label //
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        // adding label //
        JLabel lblcheckin = new JLabel("Check-In Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);

        // adding label //
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30, 240, 100, 20);
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        // adding label //
        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30, 280, 100, 20);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);

        check = new JButton("Check");
        check.setBounds(30,360,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,360,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,360,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        // adding image icon //

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

//--------------------------------------------------------------------------------------------------------------//
        // creating frame to be diplayed //
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,980,500);
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
                            tfname.setText(rs.getString("name"));
                            tfcheckin.setText(rs.getString("checkintime"));
                            tfpaid.setText(rs.getString("deposit"));
                        }

                        ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");

                        while(rs2.next()) {

                            String price = rs2.getString("price");
                            int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                            tfpending.setText("" + amountpaid);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            // for update button //

        } else if (ae.getSource() == update) {

            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();

            try {

                conn c = new conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"' ");

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
        new UpdateCheck();
    }

}
