package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.Date;
import java.sql.ResultSet;
import java.util.Date;
//import java.util.Calendar;

public class AddCustomer extends JFrame implements ActionListener{

    JComboBox comboid;
    JTextField tfnumber, tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back ;



    AddCustomer() {
        setTitle("New Customer Form");
        setLayout(null);

        JLabel text = new JLabel("New Customer");
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        text.setBounds(100,20,300,30);
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        lblid.setBounds(35,80,100,20);
        add(lblid);

        String options [] = { "Adhaar Card", "Passport", "Driving License", "Voter-ID Card", "Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        lblnumber.setBounds(35,120,100,20);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        lblname.setBounds(35,160,100,20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        lblgender.setBounds(35,200,100,20);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);


        JLabel lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        lblcountry.setBounds(35,240,100,20);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        lblroom.setBounds(35,280,150,20);
        add(lblroom);


        croom = new Choice();

        try {
            conn c = new conn();
            String query = "select * from room where availability = 'Available' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        // date for check in time //

        JLabel lbltime = new JLabel("Check-In Time");
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        lbltime.setBounds(35,320,150,20);
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel("" + date);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        checkintime.setBounds(200,320,150,25);
        add(checkintime);

        JLabel lbldp = new JLabel("Deposit");
        lbldp.setFont(new Font("Raleway",Font.PLAIN,20));
        lbldp.setBounds(35,360,100,20);
        add(lbldp);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        // creating Button //

        add = new JButton("Add Room")  ;
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back")  ;
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(200, 410, 120, 30);
        back.addActionListener(this);
        add(back);


        // creating image //

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);


        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 800, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null ;

            if  (rmale.isSelected()){
                gender = "Male";

            } else if (rfemale.isSelected()){
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {

                String query = "insert into customer values ('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + time + "', '" + deposit + "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '" + room + "' " ;

                conn c = new conn();

                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added succesfully ");
                setVisible(false);
                new hotel.management.system.Reception();


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {

            setVisible(false);
            new hotel.management.system.Reception();

        }
    }

    public static void main(String[] args) {
        new AddCustomer ();
    }
}
