import javax.swing.*;
import java.awt.*;

public class UC2_UI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Palindrome Checker - UC2");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(20);
        JButton checkButton = new JButton("Check Palindrome");
        JLabel resultLabel = new JLabel("Status: Waiting for input");

        frame.add(inputField);
        frame.add(checkButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}