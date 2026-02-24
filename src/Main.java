import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 1️⃣ Create the main window
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window

        // 2️⃣ Main panel with padding
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // each component on a new line
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // vertical spacing

        // 3️⃣ Title label
        JLabel titleLabel = new JLabel("Palindrome Checker", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, gbc);

        // 4️⃣ Input field
        JTextField inputField = new JTextField(15);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(inputField, gbc);

        // 5️⃣ Check button
        JButton checkButton = new JButton("Check Text");
        checkButton.setPreferredSize(new Dimension(100, 40));
        panel.add(checkButton, gbc);

        // 6️⃣ Result label
        JLabel resultLabel = new JLabel("Results will appear here", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(resultLabel, gbc);

        // 7️⃣ --- UC6 BUTTON LOGIC ---
        checkButton.addActionListener(e -> {
            String original = inputField.getText().trim();

            if (original.isEmpty()) {
                resultLabel.setText("⚠️ Please enter some text!");
                resultLabel.setForeground(Color.RED);
                return;
            }

            // UC6: Remove spaces/punctuation and ignore case
            String cleanInput = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // Reverse string
            String reversed = new StringBuilder(cleanInput).reverse().toString();

            // Compare
            if (cleanInput.equals(reversed)) {
                resultLabel.setText("✅ SUCCESS: It's a Palindrome!");
                resultLabel.setForeground(new Color(0, 128, 0)); // Green
            } else {
                resultLabel.setText("❌ NOPE: Not a Palindrome.");
                resultLabel.setForeground(Color.RED);
            }
        });

        // 8️⃣ Add panel to frame and show
        frame.add(panel);
        frame.setVisible(true);
    }
}