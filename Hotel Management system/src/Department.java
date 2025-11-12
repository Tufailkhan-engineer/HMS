package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;


    Department() {

        setLayout(null);



        // adding heading //
        JLabel l1 = new JLabel ("Department");
        l1.setBounds(100,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(370, 10, 100, 20);
        add(l2);



        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM department;");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        // adding back button //
        back = new JButton("Back")  ;
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(280, 400, 120, 30);
        back.addActionListener(this);
        add(back);


        // to get the frame //
        getContentPane().setBackground(Color.WHITE);
        setBounds(400,200,700,480);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new hotel.management.system.Reception();
    }

    public static void main(String[] args) {
        new Department();

    }


}
