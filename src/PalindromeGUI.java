import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeGUI extends JFrame { // <--- Start of Class

    // 1. Declarations (This is okay to be here)
    private JTextField inputField;
    private JLabel resultLabel;

    public PalindromeGUI() { // <--- Start of Constructor "Box"
        setTitle("Palindrome Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputField = new JTextField(20);
        JButton checkButton = new JButton("Check");
        resultLabel = new JLabel("Result will appear here");

        add(inputField);
        add(checkButton);
        add(resultLabel);

        checkButton.addActionListener(e -> {
            String text = inputField.getText();
            // Logic goes here
            resultLabel.setText("Checked!");
        });

        setVisible(true);
    } // <--- End of Constructor "Box" (Make sure this is AFTER setVisible)

    public static void main(String[] args) { // <--- Start of Main Method
        new PalindromeGUI();
    } // <--- End of Main Method

} // <--- End of Class