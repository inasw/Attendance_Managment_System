package frontPackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import adminPackage.adminLogIn;
import studentPackage.student;
import teacherPackage.teacherLogIn;

public class frontGUI extends JFrame implements ActionListener{
    public frontGUI(){
        
        setTitle(">>Student Attendance Management System<<");
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);
        //ImageIcon image = new ImageIcon("imgFront.jpg");
        // Create the first panel with two labels
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("                ********************WELCOME********************");
        JLabel label2 = new JLabel("     Are you:");
        //setting fornts
        label1.setFont(font);
        label2.setFont(font);
        //adding lables to the frist panel
        panel1.add(label1);
        panel1.add(label2);
        panel1.setLayout(new GridLayout(2, 1));
        // Create the second panel with three diagonal buttons
        JPanel panel2 = new JPanel();
        JButton button1 = new JButton("Adminstrator");
        button1.setFont(fontButton);
        JButton button2 = new JButton("   Teacher  ");
        button2.setFont(fontButton);
        JButton button3 = new JButton("   Student  ");
        button3.setFont(fontButton);
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //adding buttons to the grid
        panel2.add(button1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel2.add(button2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel2.add(button3, gbc);

        // Add the two panels to the JFrame using the container class method
        getContentPane().setLayout(new GridLayout(2, 1));
        getContentPane().add(panel1);
        getContentPane().add(panel2);
        // Set
        setBackground(Color.WHITE);
        setSize(1200, 800);
        setVisible(true);
        setResizable(true);

        // Add action listeners to the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Adminstrator")) {
            // Go to the administrator GUI package
            new adminLogIn();
            dispose(); // Close the current window
        } else if (e.getActionCommand().equals("   Teacher  ")) {
            // Go to the teacher GUI package
            new teacherLogIn();
            dispose(); // Close the current window
        } else if (e.getActionCommand().equals("   Student  ")) {
            // Go to the student GUI package
            new student();
            dispose(); // Close the current window
        }
    }
    
    public static void main(String[] args) {
        new frontGUI();
    }
}
