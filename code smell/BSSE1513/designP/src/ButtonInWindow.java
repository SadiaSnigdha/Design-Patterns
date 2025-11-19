import javax.swing.*;
import java.awt.event.*;

public class ButtonInWindow {
    public static void main(String[] args) {
        // উইন্ডো তৈরি
        JFrame frame = new JFrame("My Window with Button");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // নিজে নিজে layout set করতে হবে

        // বোতাম তৈরি
        JButton button = new JButton("Click Me");
        button.setBounds(100, 70, 100, 30); // বোতামের অবস্থান এবং সাইজ

        // বোতামে অ্যাকশন যুক্ত করা
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button was clicked!");
            }
        });

        // বোতাম উইন্ডোতে যোগ করা
        frame.add(button);

        // উইন্ডো দৃশ্যমান করা
        frame.setVisible(true);
    }
}
