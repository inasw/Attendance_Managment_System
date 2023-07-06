package teacherPackage;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class teacherMsg extends JFrame{
    //there reason that we didi not do the method static is that the most JFrame methods are not non static
    //which we cant make a static refrence to non static methods
        void sendMsgToStudent(){
        setTitle(">>Student Attendance Management<<");

        //font style for the label and the text area
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontLabel = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Teacher, Please enter your message here for student", SwingConstants.CENTER);
        label.setFont(fontLabel);
        add(label, BorderLayout.NORTH);

        // Create a text area and add it to the center of the window
        JTextArea textArea = new JTextArea();
        textArea.setText("Please enter your message here");
        textArea.setFont(font);
        textArea.setCaretPosition(0);
        textArea.selectAll();
        textArea.setForeground(Color.GRAY);
        textArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textArea.setText("");
                textArea.setForeground(Color.BLACK);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(textArea.getText().trim().equals("")) {
                    textArea.setText("Please enter your message here");
                    textArea.setForeground(Color.GRAY);
                }
            }
        });
        add(textArea, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton sendButton = new JButton("Send");
        sendButton.setFont(font);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 // Get the message from the text area
                 String message = textArea.getText();

                 // Store the message in a MySQL database
                 try {
                     // Load the MySQL JDBC driver
                     Class.forName("com.mysql.jdbc.Driver");
 
                     // Connect to the database
                     String url = "jdbc:mysql://localhost:3306/mydatabase";
                     String username = "root";
                     String password = "password";
                     Connection conn = DriverManager.getConnection(url, username, password);
 
                     // Create a prepared statement to insert the message into the database
                     String sql = "INSERT INTO messages (message) VALUES (?)";
                     PreparedStatement stmt = conn.prepareStatement(sql);
                     stmt.setString(1, message);
                     stmt.executeUpdate();
 
                     // Close the prepared statement and the database connection
                     stmt.close();
                     conn.close();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
 
                 // Show a pop-up message
                 JOptionPane.showMessageDialog(null, "Message sent");
 
                 // Close the current GUI
                 dispose();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(sendButton);
        add(buttonPanel, BorderLayout.SOUTH);


        // Set the window to be visible
        setVisible(true);
    }
    void sendMsgToAdmin(){
        setTitle(">>Student Attendance Management<<");
        //font style for the label and the text area
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontLabel = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Teacher, Please enter your message here for admin", SwingConstants.CENTER);
        label.setFont(fontLabel);
        add(label, BorderLayout.NORTH);

        // Create a text area and add it to the center of the window
        JTextArea textArea = new JTextArea();
        textArea.setText("Please enter your message here");
        textArea.setFont(font);
        textArea.setCaretPosition(0);
        textArea.selectAll();
        textArea.setForeground(Color.GRAY);
        textArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textArea.setText("");
                textArea.setForeground(Color.BLACK);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(textArea.getText().trim().equals("")) {
                    textArea.setText("Please enter your message here");
                    textArea.setForeground(Color.GRAY);
                }
            }
        });
        add(textArea, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton sendButton = new JButton("Send");
        sendButton.setFont(font);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Get the message from the text area
                String message = textArea.getText();

                // Store the message in a MySQL database
                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Connect to the database
                    String url = "jdbc:mysql://localhost:3306/mydatabase";
                    String username = "root";
                    String password = "password";
                    Connection conn = DriverManager.getConnection(url, username, password);

                    // Create a prepared statement to insert the message into the database
                    String sql = "INSERT INTO messages (message) VALUES (?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, message);
                    stmt.executeUpdate();

                    // Close the prepared statement and the database connection
                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Show a pop-up message
                JOptionPane.showMessageDialog(null, "Message sent");

                // Close the current GUI
                dispose();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(sendButton);
        add(buttonPanel, BorderLayout.SOUTH);


        // Set the window to be visible
        setVisible(true);
    }
    public static void main(String[] args) {
        teacherMsg msgs = new teacherMsg();
        //msgs.sendMsgToStudent();
        msgs.sendMsgToAdmin();
    }
}
