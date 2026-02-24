import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");

        if (sc.hasNextLine()) {
            String original = sc.nextLine();
            String reversed = new StringBuilder(original).reverse().toString();

            if (original.equalsIgnoreCase(reversed)) {
                System.out.println("It is a palindrome.");
            } else {
                System.out.println("It is not a palindrome.");
            }
        }
        sc.close();
    }
}