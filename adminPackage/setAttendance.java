package adminPackage;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class setAttendance extends JFrame{
    public setAttendance(){
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
        JLabel label = new JLabel("Please Enter the Below Info to Set Attendance ", SwingConstants.CENTER);
        label.setFont(font);
        add(label, BorderLayout.NORTH);

        // Create a panel for the text fields and add it to the center of the window
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 2));
        JLabel label1 = new JLabel("Batch:");
        label1.setFont(font);
        JTextField textField1 = new JTextField();
        textField1.setFont(font);
        JLabel label2 = new JLabel("Teacher Name:");
        label2.setFont(font);
        JTextField textField2 = new JTextField();
        textField2.setFont(font);
        textFieldPanel.add(label1);
        textFieldPanel.add(textField1);
        textFieldPanel.add(label2);
        textFieldPanel.add(textField2);
        add(textFieldPanel, BorderLayout.CENTER);

        // Create a button and add it to the bottom right corner of the window
        JButton button = new JButton("Set Attendance");
        button.setPreferredSize(new Dimension(300, 50));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        button.setFont(fontButton);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add an action listener to the button
        button.addActionListener(e -> {
            String batch = textField1.getText();
            String teacherName = textField2.getText();
            setAttendance(batch, teacherName);
        });

        // Set the window to be visible
        setVisible(true);
    }

    private void setAttendance(String batch, String teacherName) {
        // Retrieve the names from the student table based on the batch value
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db", "username", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT name FROM students WHERE batch='" + batch + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");

                // Insert the name, batch, and teacher's name into the attendance table
                String insertQuery = "INSERT INTO attendance (name, batch, teacher) VALUES ('" + name + "', '" + batch + "', '" + teacherName + "')";
                stmt.executeUpdate(insertQuery);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Display a message dialog to indicate that the attendance has been set
        JOptionPane.showMessageDialog(this, "Attendance has been set for batch " + batch + ".");
    }

    public static void main(String[] args) {
        new setAttendance();
    }
}
