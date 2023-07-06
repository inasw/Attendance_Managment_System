package adminPackage;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class remove extends JFrame{
    void removeStudent(){
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
       JLabel label = new JLabel("Please enter the Student ID You Want to Remove", SwingConstants.CENTER);
       label.setFont(font);
       add(label, BorderLayout.NORTH);
       //setting
       JPanel textFieldPanel = new JPanel(new GridLayout(1, 2));
       JLabel label1 = new JLabel("ID:");
       label1.setFont(font);
       JTextField textField1 = new JTextField();
       textField1.setPreferredSize(new Dimension(100, 40));
       textField1.setFont(font);
       // adding
       textFieldPanel.add(label1);
       textFieldPanel.add(textField1);
       add(textFieldPanel, BorderLayout.CENTER);

       ImageIcon icon = new ImageIcon("plus.png");

       // Create a button and add it to the bottom right corner of the window
       JButton button = new JButton("DELETE", icon);
       button.setPreferredSize(new Dimension(300, 50));
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       button.setFont(fontButton);
       buttonPanel.add(button);
       add(buttonPanel, BorderLayout.SOUTH);

       // Set the window to be visible
       setVisible(true);
    } 
    void removeTeacher(){
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
       JLabel label = new JLabel("Please enter the Teacher ID You Want to Remove", SwingConstants.CENTER);
       label.setFont(font);
       add(label, BorderLayout.NORTH);
       //setting
       JPanel textFieldPanel = new JPanel(new GridLayout(1, 2));
       JLabel label1 = new JLabel("                                 ID:");
       label1.setFont(font);
       JTextField textField1 = new JTextField();
       textField1.setPreferredSize(new Dimension(100, 40));
       textField1.setFont(font);
       // adding
       textFieldPanel.add(label1);
       textFieldPanel.add(textField1);
       add(textFieldPanel, BorderLayout.CENTER);

       ImageIcon icon = new ImageIcon("plus.png");

       // Create a button and add it to the bottom right corner of the window
       JButton button = new JButton("DELETE", icon);
       button.setPreferredSize(new Dimension(300, 50));
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       button.setFont(fontButton);
       buttonPanel.add(button);
       add(buttonPanel, BorderLayout.SOUTH);

       button.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Get the teacher's ID from the text field
            String id = textField1.getText();

            // Search for the teacher's information in a MySQL database
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Connect to the database
                String url = "jdbc:mysql://localhost:3306/mydatabase";
                String username = "root";
                String password = "password";
                Connection conn = DriverManager.getConnection(url, username, password);

                // Create a prepared statement to search for the teacher's information in the database
                String sql = "Delete FROM teachers WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();

                // Close the result set, the prepared statement, and the database connection
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // Clear the text field
            textField1.setText("");
        }
    });

       // Set the window to be visible
       setVisible(true);
    }
    public static void main(String[] args) {
       remove Remove = new remove();
       Remove.removeTeacher(); 
    }
}
