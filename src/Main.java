import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 1️⃣ Create main window
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 2️⃣ Main panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        // 3️⃣ Title
        JLabel titleLabel = new JLabel("Palindrome Checker", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, gbc);

        // 4️⃣ Input field
        JTextField inputField = new JTextField(20);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(inputField, gbc);

        // 5️⃣ Check button
        JButton checkButton = new JButton("Check Text");
        checkButton.setPreferredSize(new Dimension(120, 40));
        panel.add(checkButton, gbc);

        // 6️⃣ Result label
        JLabel resultLabel = new JLabel("Results will appear here", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(resultLabel, gbc);

        // 7️⃣ History list
        DefaultListModel<String> historyModel = new DefaultListModel<>();
        JList<String> historyList = new JList<>(historyModel);
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        panel.add(scrollPane, gbc);

        // 8️⃣ --- UC6 + UC7 + UC8 + UC9 BUTTON LOGIC ---
        checkButton.addActionListener(e -> {
            String original = inputField.getText().trim();

            if (original.isEmpty()) {
                resultLabel.setText("⚠️ Please enter some text!");
                resultLabel.setForeground(Color.RED);
                return;
            }

            // UC6 + UC8: clean input
            String cleanInput = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String reversed = new StringBuilder(cleanInput).reverse().toString();

            // UC7: character count
            int length = original.length();

            boolean isPalindrome = cleanInput.equals(reversed);

            if (isPalindrome) {
                resultLabel.setText("✅ Palindrome! Length: " + length);
                resultLabel.setForeground(new Color(0, 128, 0));
            } else {
                resultLabel.setText("❌ Not a palindrome. Length: " + length);
                resultLabel.setForeground(Color.RED);
            }

            // UC9: add entry to history
            historyModel.addElement(original + " → " + (isPalindrome ? "Palindrome" : "Not Palindrome"));
        });

        // 9️⃣ Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }
}