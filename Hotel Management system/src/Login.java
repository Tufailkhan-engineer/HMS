package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    // making global //
    JTextField username, Password;
    JButton Login, Cancel;

    Login() {

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        Password = new JTextField();
        Password.setBounds(150, 70, 150, 30);
        add(Password);

        Login = new JButton("Login");
        Login.setBounds(40, 150, 120, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(180, 150, 120, 30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);
// adding image //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    // function //
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Login) {

            String user = username.getText();
            String pass = Password.getText();

            try {

                conn c = new conn();
                // query //
                String query = "select * from login where username='" + user + "' and password='" + pass + "' ";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "invalid");
                    setVisible(false);
                }

                } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == Cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
