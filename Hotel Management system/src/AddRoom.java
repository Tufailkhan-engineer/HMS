package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField tfroomno,tfprice;
    JComboBox typecombo,cleancombo,availablecombo;


    AddRoom() {
        setLayout(null);
// creating heading label //

        JLabel heading = new JLabel("ADD ROOM");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma",Font.BOLD,17));
        add(heading);

// creating Room no. label //

        JLabel lblroomno = new JLabel("ROOM NUMBER");
        lblroomno.setBounds(60, 80, 120, 20);
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblroomno);

        //text field inform of the label //
        tfroomno= new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        add(tfroomno);

 // creating Room availability label //

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60, 130, 120, 30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblavailable);

        // dropdon option //

        String availableOption[] = { "Available", "Occupied" } ;
                 availablecombo =  new JComboBox(availableOption);
                availablecombo.setBounds(200,130,150,30);
                availablecombo.setBackground(Color.WHITE);
                add(availablecombo);

// creating Room cleaning ztatuz combobox //

        JLabel lblclean = new JLabel("Cleaning status ");
        lblclean.setBounds(60, 180, 120, 30);
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblclean);

        // dropdown option //

        String cleanOption[] = { "Cleaned", "Dirty" } ;
             cleancombo =  new JComboBox(cleanOption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        // creating a label and text field for room price //

        JLabel lblprice = new JLabel("Room Price");
        lblprice.setBounds(60, 230, 120, 20);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblprice);

        //text field inform of the label //
         tfprice= new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        // creating combobox //
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60, 280, 120, 30);
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltype);

        // dropdown option //

        String typeOptions[] = { "single bed", "double bed" } ;
         typecombo =  new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

    // creating Button //

         add = new JButton("Add Room")  ;
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

         cancel = new JButton("Cancel")  ;
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

    // adding image icon //

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);

    // Creating frame to be displayed
        getContentPane().setBackground(Color.WHITE);
        setBounds(330, 200, 940, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the app closes properly
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){

            String roomnumber = tfroomno.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String type = (String) typecombo.getSelectedItem();
            String price = tfprice.getText();

            try {
// creating connection //
                conn c = new conn();
// creating query //
                String str = "insert into room values ('" + roomnumber + "', '" + availability + "', '" + status + "','" + price + "','" + type + "')";
//execute query //
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Room Added succesfully ");

                setVisible(false);


            } catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
