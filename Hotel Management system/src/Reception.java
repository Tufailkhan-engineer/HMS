package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    // global declare //

    JButton c1,room,department,allemployee,c2,manager,checkout,update,updateRoomStatus,pickup,Searchroom,logout;
    private System system;

    Reception() {

        setLayout(null);


        // creating button 1 //
         c1 = new JButton("New Customer Form");
        c1.setBounds(10,30,200,30);
        c1.setForeground(Color.WHITE);
        c1.setBackground(Color.BLACK);
        c1.addActionListener(this);
        add(c1);

        // creating button 2//
         room = new JButton("Room");
        room.setBounds(10,70,200,30);
        room.setForeground(Color.WHITE);
        room.setBackground(Color.BLACK);
        room.addActionListener(this);
        add(room);

        // creating button 3//
         department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setForeground(Color.WHITE);
        department.setBackground(Color.BLACK);
        department.addActionListener(this);
        add(department);

        // creating button 4//
         allemployee = new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setForeground(Color.WHITE);
        allemployee.setBackground(Color.BLACK);
        allemployee.addActionListener(this);
        add(allemployee);

        // creating button 5//
         c2 = new JButton("Customer Info");
        c2.setBounds(10,190,200,30);
        c2.setForeground(Color.WHITE);
        c2.setBackground(Color.BLACK);
        c2.addActionListener(this);
        add(c2);

        // creating button 6//
         manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setForeground(Color.WHITE);
        manager.setBackground(Color.BLACK);
        manager.addActionListener(this);
        add(manager);

        // creating button 7//
         checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);

        // creating button 7//
         update = new JButton("Update Status ");
        update.setBounds(10,310,200,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        // creating button 8//
         updateRoomStatus = new JButton("Update Room Status ");
        updateRoomStatus.setBounds(10,350,200,30);
        updateRoomStatus.setForeground(Color.WHITE);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);

        // creating button 9//
         pickup = new JButton("Pickup Service ");
        pickup.setBounds(10,390,200,30);
        pickup.setForeground(Color.WHITE);
        pickup.setBackground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);

        // creating button 10//
         Searchroom = new JButton("Search Room");
        Searchroom.setBounds(10,430,200,30);
        Searchroom.setForeground(Color.WHITE);
        Searchroom.setBackground(Color.BLACK);
        Searchroom.addActionListener(this);
        add(Searchroom);

        // creating button 11//
         logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);

        // adding image //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);



        // to get the frame //
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,800,570);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {

        if (ae.getSource() == c1) {
            setVisible(false);
            new hotel.management.system.AddCustomer();

        } else if (ae.getSource() == room) {
            setVisible(false);
            new hotel.management.system.Room();

        } else if (ae.getSource() == department) {
            setVisible(false);
            new hotel.management.system.Department();

        } else if (ae.getSource() == allemployee) {
            setVisible(false);
            new hotel.management.system.EmployeeInfo();

        } else if (ae.getSource() == manager) {
            setVisible(false);
            new hotel.management.system.ManagerInfo();

        } else if (ae.getSource() == c2) {
            setVisible(false);
            new hotel.management.system.CustomerInfo();

        } else if (ae.getSource() == Searchroom) {
            setVisible(false);
            new hotel.management.system.SearchRoom();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new hotel.management.system.UpdateCheck();

        } else if (ae.getSource() == updateRoomStatus) {
            setVisible(false);
            new hotel.management.system.UpdateRoom();

        } else if (ae.getSource() == pickup) {
            setVisible(false);
            new hotel.management.system.Pickup();

        } else if (ae.getSource() == checkout) {
            setVisible(false);
            new hotel.management.system.Checkout();

        } else if (ae.getSource() == logout) {
            setVisible(false);
            system.exit(0);

        }

    }

    public static void main(String[] args) {

        new Reception();
    }
}
