import javax.swing.*;

public class UC1_Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Palindrome Checker - UC1");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Window Initialized", SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}