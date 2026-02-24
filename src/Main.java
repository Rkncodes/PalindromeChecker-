import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 1️⃣ Create main window
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 2️⃣ Main panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        // 3️⃣ Title label
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

        // 8️⃣ Theme toggle button (UC10)
        JButton themeButton = new JButton("Toggle Theme");
        themeButton.setPreferredSize(new Dimension(150, 40));
        panel.add(themeButton, gbc);

        // 9️⃣ Track theme state
        final boolean[] darkTheme = {false};

        themeButton.addActionListener(e -> {
            darkTheme[0] = !darkTheme[0]; // toggle state
            if (darkTheme[0]) {
                panel.setBackground(Color.DARK_GRAY);
                titleLabel.setForeground(Color.WHITE);
                resultLabel.setForeground(Color.WHITE);
                historyList.setBackground(Color.GRAY);
                historyList.setForeground(Color.WHITE);
                inputField.setBackground(Color.LIGHT_GRAY);
                inputField.setForeground(Color.BLACK);
            } else {
                panel.setBackground(Color.WHITE);
                titleLabel.setForeground(Color.BLACK);
                resultLabel.setForeground(Color.BLACK);
                historyList.setBackground(Color.WHITE);
                historyList.setForeground(Color.BLACK);
                inputField.setBackground(Color.WHITE);
                inputField.setForeground(Color.BLACK);
            }
            panel.revalidate();
            panel.repaint();
        });

        //  🔟 --- UC6 + UC7 + UC8 + UC9 BUTTON LOGIC ---
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

            // UC7: count characters
            int length = original.length();

            boolean isPalindrome = cleanInput.equals(reversed);

            if (isPalindrome) {
                resultLabel.setText("✅ Palindrome! Length: " + length);
                resultLabel.setForeground(darkTheme[0] ? Color.WHITE : new Color(0, 128, 0));
            } else {
                resultLabel.setText("❌ Not a palindrome. Length: " + length);
                resultLabel.setForeground(darkTheme[0] ? Color.WHITE : Color.RED);
            }

            // UC9: add to history
            historyModel.addElement(original + " → " + (isPalindrome ? "Palindrome" : "Not Palindrome"));
        });

        // 1️⃣1️⃣ Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }
}