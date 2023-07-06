package teacherPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AttendanceFrame extends JFrame implements ActionListener{

    private JLabel titleLabel;
    private JPanel namesPanel;
    private JTextField yearField;
    private JTextField teacherField;

    public AttendanceFrame() {
        super("Attendance");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the title label
        titleLabel = new JLabel("Taking Attendance");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create the panel to accept the year and teacher name
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setFont(new Font("Arial", Font.BOLD, 35));
        inputPanel.add(yearLabel);

        yearField = new JTextField();
        yearField.setFont(new Font("Arial", Font.BOLD, 25));
        inputPanel.add(yearField);

        JLabel teacherLabel = new JLabel("Teacher:");
        teacherLabel.setFont(new Font("Arial", Font.BOLD, 35));
        inputPanel.add(teacherLabel);

        teacherField = new JTextField();
        teacherField.setFont(new Font("Arial", Font.BOLD, 25));
        inputPanel.add(teacherField);

        add(inputPanel, BorderLayout.CENTER);

        // Create the panel to display the names and attendance status
        namesPanel = new JPanel();
        namesPanel.setLayout(new GridLayout(0, 4));

        add(namesPanel, BorderLayout.SOUTH);

        // Create the button to retrieve the attendance data
        JButton retrieveButton = new JButton("Retrieve Attendance");
        retrieveButton.setFont(new Font("Arial", Font.PLAIN, 25));
        retrieveButton.addActionListener(this);
        add(retrieveButton, BorderLayout.SOUTH);

        // Set the size and make the frame visible
        setSize(1200, 800);
        setVisible(true);
    }

    private void retrieveAttendance(String year, String teacherName) {
        // Clear the names panel
        namesPanel.removeAll();

        // Add the labels and radio buttons for each name
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db", "username", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT name FROM students WHERE year='" + year + "' AND teacher='" + teacherName + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                JLabel nameLabel = new JLabel(name);
                nameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
                nameLabel.setHorizontalAlignment(JLabel.CENTER);
                namesPanel.add(nameLabel);

                JRadioButton presentButton = new JRadioButton("P");
                presentButton.setActionCommand("P");
                namesPanel.add(presentButton);

                JRadioButton absentButton = new JRadioButton("A");
                absentButton.setActionCommand("A");
                namesPanel.add(absentButton);

                JRadioButton lateButton = new JRadioButton("p");
                lateButton.setActionCommand("p");
                namesPanel.add(lateButton);

                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(presentButton);
                buttonGroup.add(absentButton);
                buttonGroup.add(lateButton);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Refresh the names panel
        namesPanel.revalidate();
        namesPanel.repaint();
    }

    public static void main(String[] args) {
        new AttendanceFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String year = yearField.getText();
        String teacherName = teacherField.getText();
        retrieveAttendance(year, teacherName);
    }
}
