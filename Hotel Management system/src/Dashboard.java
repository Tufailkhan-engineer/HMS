package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard() {
        setBounds(0,0,1550,1000);

        setLayout(null);

        /* for image in the frame */
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        /* adding text */
        JLabel text = new JLabel("The Elite Hotel Welcome You!");
        text.setBounds(450,80,1000,50);
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif", Font.PLAIN, 50));

        //menu bar //
        JMenuBar mb = new JMenuBar();
        mb.setBounds(600,350,310,30);
        image.add(mb);


        //adding option in menu {1}//
        JMenu hotel = new JMenu("      Hotel Management   ");
        hotel.setForeground(Color.RED);
        hotel.setBackground(Color.WHITE);
        hotel.setFont(new Font("Arial", Font.BOLD, 16));
        mb.add(hotel);

        // adding hm menu dropdown option //
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        reception.setFont(new Font("Arial", Font.BOLD, 16));
        hotel.add(reception);

        //adding option in menu {2}//
        JMenu admin = new JMenu("     Admin     ");
        admin.setForeground(Color.BLUE);
        admin.setBackground(Color.WHITE);
        admin.setFont(new Font("Arial", Font.BOLD, 16));
        mb.add(admin);

        // adding admin menu dropdown option //
        JMenuItem addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        addemployee.setFont(new Font("Arial", Font.BOLD, 16));
        admin.add(addemployee);

        // adding admin menu dropdown option //
        JMenuItem addroom = new JMenuItem("Add Room");
        addroom.addActionListener(this);
        addroom.setFont(new Font("Arial", Font.BOLD, 16));
        admin.add(addroom);

        // adding admin menu dropdown option //
        JMenuItem adddriver = new JMenuItem("Add Driver");
        adddriver.addActionListener(this);
        adddriver.setFont(new Font("Arial", Font.BOLD, 16));
        admin.add(adddriver);

        // to get the frame //
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add Employee")){
            new hotel.management.system.AddEmployee();
        } else if (ae.getActionCommand().equals("Add Room")) {
            new hotel.management.system.AddRoom();
        } else if (ae.getActionCommand().equals("Add Driver")) {
            new hotel.management.system.AddDriver();
        } else if (ae.getActionCommand().equals("Reception")) {
            new hotel.management.system.Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }

}
