package adminPackage;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class add extends JFrame{
    public void addStudent(){
        //fonts to style our lables and buttons
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        // Set the title of the window
        setTitle(">>Student Attendance Management<<");

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Please enter the Student Info You Want to Add", SwingConstants.CENTER);
        label.setFont(font);
        add(label, BorderLayout.NORTH);

        // Create a panel for the text fields and add it to the center of the window
        JPanel textFieldPanel = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Name:");
        label1.setFont(font);
        JTextField textField1 = new JTextField();
        textField1.setFont(font);
        JLabel label2 = new JLabel("ID:");
        label2.setFont(font);
        JTextField textField2 = new JTextField();
        textField2.setFont(font);
        JLabel label3 = new JLabel("Department:");
        label3.setFont(font);
        JTextField textField3 = new JTextField();
        textField3.setFont(font);
        JLabel label4 = new JLabel("Year:");
        label4.setFont(font);
        JTextField textField4 = new JTextField();
        textField4.setFont(font);
        textFieldPanel.add(label1);
        textFieldPanel.add(textField1);
        textFieldPanel.add(label2);
        textFieldPanel.add(textField2);
        textFieldPanel.add(label3);
        textFieldPanel.add(textField3);
        textFieldPanel.add(label4);
        textFieldPanel.add(textField4);
        add(textFieldPanel, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton button = new JButton("ADD");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        button.setFont(fontButton);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add an action listener to the button
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Get the teacher's information from the text fields
                String name = textField1.getText();
                String id = textField2.getText();
                String department = textField3.getText();
                String year = textField4.getText();

                // Store the teacher's information in a MySQL database
                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Connect to the database
                    String url = "jdbc:mysql://localhost:3306/mydatabase";
                    String username = "root";
                    String password = "password";
                    Connection conn = DriverManager.getConnection(url, username, password);

                    // Create a prepared statement to insert the teacher's information into the database
                    String sql = "INSERT INTO teachers (name, id, department, year) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setString(2, id);
                    stmt.setString(3, department);
                    stmt.setString(4, year);
                    stmt.executeUpdate();

                    // Close the prepared statement and the database connection
                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Show a pop-up message
                JOptionPane.showMessageDialog(null, "Student added");

                // Clear the text fields
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });

        // Set the window to be visible
        setVisible(true);
    }
    public void addTeacher(){
        //fonts to style our lables and buttons
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30);

        // Set the title of the window
        setTitle(">>Student Attendance Management<<");

        // Set the size of the window
        setSize(1200, 800);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a label and add it to the top center of the window
        JLabel label = new JLabel("Please enter the Teachers Info You Want to Add", SwingConstants.CENTER);
        label.setFont(font);
        add(label, BorderLayout.NORTH);

        // Create a panel for the text fields and add it to the center of the window
        JPanel textFieldPanel = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Name:");
        label1.setFont(font);
        JTextField textField1 = new JTextField();
        textField1.setFont(font);
        JLabel label2 = new JLabel("ID:");
        label2.setFont(font);
        JTextField textField2 = new JTextField();
        textField2.setFont(font);
        JLabel label3 = new JLabel("Teaching course:");
        label3.setFont(font);
        JTextField textField3 = new JTextField();
        textField3.setFont(font);
        JLabel label4 = new JLabel("Teaching Year:");
        label4.setFont(font);
        JTextField textField4 = new JTextField();
        textField4.setFont(font);
        textFieldPanel.add(label1);
        textFieldPanel.add(textField1);
        textFieldPanel.add(label2);
        textFieldPanel.add(textField2);
        textFieldPanel.add(label3);
        textFieldPanel.add(textField3);
        textFieldPanel.add(label4);
        textFieldPanel.add(textField4);
        add(textFieldPanel, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton button = new JButton("ADD");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        button.setFont(fontButton);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

         // Add an action listener to the button
         button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Get the teacher's information from the text fields
                String name = textField1.getText();
                String id = textField2.getText();
                String course = textField3.getText();
                String year = textField4.getText();

                // Store the teacher's information in a MySQL database
                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Connect to the database
                    String url = "jdbc:mysql://localhost:3306/mydatabase";
                    String username = "root";
                    String password = "password";
                    Connection conn = DriverManager.getConnection(url, username, password);

                    // Create a prepared statement to insert the teacher's information into the database
                    String sql = "INSERT INTO teachers (name, id, course, year) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setString(2, id);
                    stmt.setString(3, course);
                    stmt.setString(4, year);
                    stmt.executeUpdate();

                    // Close the prepared statement and the database connection
                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Show a pop-up message
                JOptionPane.showMessageDialog(null, "Teacher added");

                // Clear the text fields
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });

        // Set the window to be visible
        setVisible(true);
    }
    public static void main(String[] args) {
        add ADD = new add();
        ADD.addTeacher();
    }
}
