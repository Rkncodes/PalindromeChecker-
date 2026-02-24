import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 1. Create the window
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center on screen

        // 2. Main Panel with Padding
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Force next component to a new line
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // Vertical spacing

        // 3. Title
        JLabel titleLabel = new JLabel("Palindrome Checker", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, gbc);

        // 4. Input Field
        JTextField inputField = new JTextField(15);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(inputField, gbc);

        // 5. Check Button
        JButton checkButton = new JButton("Check Text");
        checkButton.setPreferredSize(new Dimension(100, 40));
        panel.add(checkButton, gbc);

        // 6. Result Label
        JLabel resultLabel = new JLabel("Results will appear here", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(resultLabel, gbc);

        // --- BUTTON LOGIC ---
        checkButton.addActionListener(e -> {
            String original = inputField.getText().trim();

            if (original.isEmpty()) {
                resultLabel.setText("⚠️ Please enter some text!");
                resultLabel.setForeground(Color.RED);
                return;
            }

            // Logic: Reverse and compare (UC3 included)
            String reversed = new StringBuilder(original).reverse().toString();

            if (original.equalsIgnoreCase(reversed)) {
                resultLabel.setText("✅ SUCCESS: It's a Palindrome!");
                resultLabel.setForeground(new Color(0, 128, 0)); // Green
            } else {
                resultLabel.setText("❌ NOPE: Not a Palindrome.");
                resultLabel.setForeground(Color.RED);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}