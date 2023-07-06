package teacherPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class teacher extends JFrame implements ActionListener {

    public teacher(){
        JLabel label;
        JPanel buttonPanel;
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);
        setTitle("My GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the label
        label = new JLabel("Welcome Teacher");
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.NORTH);
        //creating a code layout for the buttons to be diagonla
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Create the button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 1 row, variable number of columns, 10px horizontal gap, 0px vertical gap
        JButton btn1 = new JButton("Take Attendance");
        btn1.setFont(fontButton);
        buttonPanel.add(btn1,gbc);
        JButton btn2 = new JButton("Send Msgs To Student");
        gbc.gridx = 1;
        gbc.gridy = 1;
        btn2.setFont(fontButton);
        buttonPanel.add(btn2,gbc);
        JButton btn3 = new JButton("Send Msgs To Administrator");
        gbc.gridx = 2;
        gbc.gridy = 2;
        btn3.setFont(fontButton);
        buttonPanel.add(btn3, gbc);
        getContentPane().setLayout(new GridLayout(1, 1));
        getContentPane().add(buttonPanel);
        setVisible(true);
        setSize(1200, 800);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Take Attendance")) {
            // Go to the administrator GUI package
            new AttendanceFrame();
            dispose(); // Close the current window
        } else if (e.getActionCommand().equals("Send Msgs To Student")) {
            // Go to the teacher GUI package
            teacherMsg msgs  = new teacherMsg();
            msgs.sendMsgToStudent();
            dispose(); // Close the current window
        } else if (e.getActionCommand().equals("Send Msgs To Administrator")) {
            // Go to the student GUI package
            teacherMsg msgs  = new teacherMsg();
            msgs.sendMsgToAdmin();
            dispose(); // Close the current window
        }
    }

    public static void main(String[] args) {
        new teacher();
    }
}