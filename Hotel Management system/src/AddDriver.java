package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox typecombo,gendercombo,availablecombo;


    AddDriver() {
        setLayout(null);
// creating heading label //

        JLabel heading = new JLabel("ADD DRIVER");
        heading.setBounds(150, 10, 200, 20);
        heading.setFont(new Font("Tahoma",Font.BOLD,17));
        add(heading);

// creating Room no. label //

        JLabel lblroomno = new JLabel("NAME");
        lblroomno.setBounds(60, 70, 120, 30);
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblroomno);

        //text field inform of the label //
        tfname= new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        // creating Room availability label //

        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 110, 120, 30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblage);


        tfage= new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

// creating Room cleaning ztatuz combobox //

        JLabel lblclean = new JLabel("Gender");
        lblclean.setBounds(60, 150, 120, 30);
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblclean);

        // dropdown option //

        String genderOption[] = { "Male", "Female" } ;
        gendercombo =  new JComboBox(genderOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        // creating a label and text field for room price //

        JLabel lblprice = new JLabel("Car Company");
        lblprice.setBounds(60, 190, 120, 20);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblprice);

        //text field inform of the label //
        tfcompany= new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        // creating combobox //
        JLabel lbltype = new JLabel("Car Model");
        lbltype.setBounds(60, 230, 120, 30);
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltype);

        // dropdown option //

        tfmodel= new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);

// availability //
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60, 270, 120, 30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblavailable);

        // combobox //
        String driverOption[] = { "Available", "Buzy" } ;
        availablecombo =  new JComboBox(driverOption);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(60, 310, 120, 30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbllocation);

        tflocation= new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);

        // creating Button //

        add = new JButton("Add Driver")  ;
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel")  ;
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        // adding image icon //

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        // Creating frame to be displayed
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the app closes properly
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){

            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();


            try {
// creating connection //
                conn c = new conn();
// creating query //
                String str = "insert into driver values ('" + name + "', '" + age + "', '" + gender + "','" + company + "','" + model + "','" + availability + "','" + location + "')";
//execute query //
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Driver Added succesfully ");

                setVisible(false);


            } catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
