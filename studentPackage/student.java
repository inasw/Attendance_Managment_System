package studentPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class student extends JFrame implements ActionListener{
    JButton button1;
    JButton button2;
    public student(){
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        setTitle("Student Attendance Management");

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Welcome Student", SwingConstants.CENTER);
        label.setFont(font);
        add(label, BorderLayout.NORTH);

        // Create a panel for the buttons and add it to the center of the window
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        button1 = new JButton("Check Status");
        button1.addActionListener(this);
        button1.setFont(fontButton);
        button1.setBackground(Color.LIGHT_GRAY);
        button2 = new JButton("View Msgs");
        button2.addActionListener(this);
        button2.setFont(fontButton);
        button2.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        add(buttonPanel, BorderLayout.CENTER);

        // Set the window to be visible
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new student();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Check Status")) {
            new checkStatus();
            dispose(); // Close the current window
        } else if (e.getActionCommand().equals("View Msgs")) {
            new getMsgs();
            dispose(); // Close the current window
        } 
    }
}
