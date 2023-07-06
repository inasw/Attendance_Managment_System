package adminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminLogIn extends JFrame implements ActionListener{
    JLabel label;
    JTextField field;
    JPasswordField pass;
    public adminLogIn(){
        JFrame frame = new JFrame(">>Student Attendance Management<<");
        Font fontLabel = new Font("timesRoman", Font.BOLD | Font.ITALIC, 30);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        label=new JLabel("Welcome Adminstrator");
        label.setFont(fontLabel);
        panel.add(label, constraints);
        constraints.gridy = 1;
        JLabel label2 = new JLabel("Useranme");
        label2.setFont(fontLabel);
        panel.add(label2, constraints);
        constraints.gridy = 2;
        field = new JTextField(20);
        field.setPreferredSize(new Dimension(100, 40));
        panel.add(field, constraints);
        constraints.gridy = 3;
        JLabel labe2 = new JLabel("Password");
        labe2.setFont(fontLabel);
        panel.add(labe2, constraints);
        constraints.gridy = 4;
        pass = new JPasswordField(20);
        pass.setPreferredSize(new Dimension(100, 40));
        panel.add(pass, constraints);
        constraints.insets = new Insets(10, 0, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        JButton btn = new JButton("Login");
        btn.addActionListener(this);
        btn.setFont(fontLabel);
        constraints.gridx=1;
        panel.add(btn, constraints);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 800);
    }

    public static void main(String[] args) {
          new adminLogIn();  
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        String username = field.getText();
        String password = new String(pass.getPassword());
        if (username.equals("admin") && password.equals("password")) {
            // Go to the teacher GUI package
            new admin();
            dispose(); // Close the current window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }

    }
}
