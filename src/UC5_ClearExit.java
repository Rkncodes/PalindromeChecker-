import javax.swing.*;
import java.awt.*;

public class UC5_ClearExit {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UC5: Clear and Exit");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(15);
        JButton checkBtn = new JButton("Check");
        JButton clearBtn = new JButton("Clear");
        JButton exitBtn = new JButton("Exit");
        JLabel resultLabel = new JLabel("Status: Ready");

        checkBtn.addActionListener(e -> {
            String clean = inputField.getText().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            resultLabel.setText(clean.equals(new StringBuilder(clean).reverse().toString()) ? "Yes!" : "No!");
        });

        // Clear button logic
        clearBtn.addActionListener(e -> {
            inputField.setText("");
            resultLabel.setText("Status: Cleared");
        });

        // Exit button logic
        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(inputField);
        frame.add(checkBtn);
        frame.add(clearBtn);
        frame.add(exitBtn);
        frame.add(resultLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}