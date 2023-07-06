package teacherPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class teacherLogIn extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public teacherLogIn(){
        JFrame frame = new JFrame(">>Student Attendance Management<<");
        Font fontLabel = new Font("timesRoman", Font.BOLD | Font.ITALIC, 30);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel label=new JLabel("Teacher! Please fill out the following!");
        label.setFont(fontLabel);
        panel.add(label, constraints);
        constraints.gridy = 1;
        JLabel label2 = new JLabel("Username");
        label2.setFont(fontLabel);
        panel.add(label2, constraints);
        constraints.gridy = 2;
        usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(100, 40));
        panel.add(usernameField, constraints);
        constraints.gridy = 3;
        JLabel label3 = new JLabel("Password");
        label3.setFont(fontLabel);
        panel.add(label3, constraints);
        constraints.gridy = 4;
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(100, 40));
        panel.add(passwordField, constraints);
        constraints.insets = new Insets(10, 0, 0, 0);
        constraints.anchor = GridBagConstraints.EAST;
        JButton btn = new JButton("Login");
        btn.setFont(fontLabel);
        panel.add(btn, constraints);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 800);

        // Add action listener to the "Login" button
        btn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Check if the username and password are correct
        if (username.equals("teacher") && password.equals("password")) {
            // Go to the teacher GUI package
            new teacher();
            dispose(); // Close the current window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }
    }

    public static void main(String[] args) {
        new teacherLogIn();
    }
}