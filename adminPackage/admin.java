package adminPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener{
    public admin(){
        Font font = new Font("Helvetica", Font.BOLD, 40);
        Font fontButton = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20);
        JLabel label1, label2;
        JPanel buttonPanel1, buttonPanel2;
 
        JButton[] buttons1 = new JButton[4];
        JButton[] buttons2 = new JButton[4];
        String[] btn1={"Add Student","Add Teacher","Remove Student","Remove Teacher"};
        String[] btn2={"Search Student","Search Teacher","See Notification","Set Attendance"};

        setTitle(">>Student Attendance Managememnt<<");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2200, 1000);
        setLocationRelativeTo(null);

        // Create the labels
        label1 = new JLabel(" Welcome Teacher");
        label1.setFont(font);
        label1.setHorizontalAlignment(JLabel.CENTER);
        add(label1, BorderLayout.NORTH);

        label2 = new JLabel("What Do You Want to Do:");
        label2.setFont(font);
        label2.setHorizontalAlignment(JLabel.CENTER);
        add(label2, BorderLayout.SOUTH);

        // Create the button panels
        buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(1, 0, 10, 0)); // 1 row, variable number of columns, 10px horizontal gap, 0px vertical gap
        buttons1 = new JButton[4];
        for(int i = 0; i < 4; i++) {
            buttons1[i]=new JButton(String.valueOf(btn1[i]));
            buttons1[i].setFont(fontButton);
            buttons1[i].addActionListener(this); // Add action listener to the button
            buttonPanel1.add(buttons1[i]);
        }
        add(buttonPanel1, BorderLayout.WEST);

        buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new GridLayout(1, 0, 10, 0)); // 1 row, variable number of columns, 10px horizontal gap, 0px vertical gap
        buttons2 = new JButton[4];
        for (int i = 0; i < 4; i++) {
            buttons2[i]=new JButton(String.valueOf(btn2[i]));
            buttons2[i].setFont(fontButton);
            buttons2[i].addActionListener(this); // Add action listener to the button
            buttonPanel2.add(buttons2[i]);
        }
        add(buttonPanel2, BorderLayout.EAST);

        // Show the frame
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        String buttonValue = e.getActionCommand();

        // Check which button was clicked and call the appropriate GUI component
        if (buttonValue.equals("Add Student")) {
            add Add = new add();
            Add.addStudent();
        } else if (buttonValue.equals("Add Teacher")) {
            add Add = new add();
            Add.addTeacher();
        } else if (buttonValue.equals("Remove Student")) {
            remove Remove = new remove();
            Remove.removeStudent();
        } else if (buttonValue.equals("Remove Teacher")) {
            remove Remove = new remove();
            Remove.removeTeacher();
        } else if (buttonValue.equals("Search Student")) {
            search Search = new search();
            Search.searchStudent();
        } else if (buttonValue.equals("Search Teacher")) {
            search Search = new search();
            Search.searchStudent();
        } else if (buttonValue.equals("See Notification")) {
            msgs Msgs = new msgs();
            Msgs.msgsFromStudent();
        } else if (buttonValue.equals("Set Attendance")) {
            new setAttendance();
        }
    }

    public static void main(String[] args) {
        new admin();
    }
}
