package studentPackage;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class checkStatus extends JFrame implements ActionListener{
    JButton button;
    public checkStatus(){
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
                JLabel label = new JLabel("Please Enter The Below Info to Check ", SwingConstants.CENTER);
                label.setFont(font);
                add(label, BorderLayout.NORTH);
        
                // Create a panel for the text fields and add it to the center of the window
                JPanel textFieldPanel = new JPanel(new GridLayout(1, 2));
                JLabel label1 = new JLabel("Student ID:");
                label1.setFont(font);
                JTextField textField1 = new JTextField();
                textField1.setFont(font);
                textFieldPanel.add(label1);
                textFieldPanel.add(textField1);
                add(textFieldPanel, BorderLayout.CENTER);

                 // Create a button and add it to the bottom right corner of the window
                button = new JButton("Check");
                button.addActionListener(this);
                button.setPreferredSize(new Dimension(300, 50));
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                button.setFont(fontButton);
                buttonPanel.add(button);
                add(buttonPanel, BorderLayout.SOUTH);

                // Set the window to be visible
                setVisible(true);
    }
    public static void main(String[] args) {
        new checkStatus();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Check")) {
            JOptionPane.showMessageDialog(this, "thanks checking status!!");
            dispose(); // Close the current window
        }
    }
}
