package adminPackage;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class msgs extends JFrame implements ActionListener{
    void msgsFromStudent(){
        //setting fonts
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        // Set the title of the window
        setTitle(">>Student Attendance Management<<");

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Messages From Students", SwingConstants.CENTER);
        label.setFont(font);
        add(label, BorderLayout.NORTH);

        // Create a panel for the messages and add it to the center of the window
        JPanel messagePanel = new JPanel(new GridLayout(0, 1));
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "WondTib@12");

            // Create a statement and execute a query to retrieve messages from the "msgs" table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM msgs");

            // Loop through the result set and add each message to the message panel
            while (rs.next()) {
                String message =rs.getString("message");
                message= message+", ";
                JLabel messageLabel = new JLabel(message);
                messagePanel.add(messageLabel);
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        add(messagePanel, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton button = new JButton("Finish");
        button.setFont(fontButton);
        button.setPreferredSize(new Dimension(300, 50));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        button.setFont(fontButton);
        button.addActionListener(this);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);
        

        // Set the window to be visible
        setVisible(true);
    }
    void msgsFromTeacher(){
        //setting fonts
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        // Set the title of the window
        setTitle(">>Student Attendance Management<<");

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Messages From Teacher", SwingConstants.CENTER);
        label.setFont(font);
        add(label, BorderLayout.NORTH);

        // Create a panel for the messages and add it to the center of the window
        JPanel messagePanel = new JPanel(new GridLayout(0, 1));
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "WondTib@12");

            // Create a statement and execute a query to retrieve messages from the "msgs" table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM msgs");

            // Loop through the result set and add each message to the message panel
            while (rs.next()) {
                String message =rs.getString("message");
                message= message+", ";
                JLabel messageLabel = new JLabel(message);
                messagePanel.add(messageLabel);
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        add(messagePanel, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton button = new JButton("Finish");
        button.setFont(fontButton);
        button.setPreferredSize(new Dimension(300, 50));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        button.setFont(fontButton);
        button.addActionListener(this);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the window to be visible
        setVisible(true);
     }
    public static void main(String[] args) {
        msgs Msgs = new msgs();
        Msgs.msgsFromStudent();
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "Thank you for checking your messages!"); 
        System.exit(0);
    }
}
