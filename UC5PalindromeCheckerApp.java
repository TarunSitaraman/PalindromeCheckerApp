
import java.util.Scanner;
import java.util.Stack;

public class UC5PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Stack-Based Palindrome Checker ---");
        System.out.print("Enter a string to check: ");

        String input = scanner.nextLine();

        if (checkPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome!");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindrome(String text) {

        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cleanText.length(); i++) {
            stack.push(cleanText.charAt(i));
        }

        for (int i = 0; i < cleanText.length(); i++) {
            char originalChar = cleanText.charAt(i);
            char reversedChar = stack.pop();

            if (originalChar != reversedChar) {
                return false;
            }
        }

        return true;
    }
}
