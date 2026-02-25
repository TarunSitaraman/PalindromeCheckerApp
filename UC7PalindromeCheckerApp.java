
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UC7PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (checkPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        scanner.close();
    }

    public static boolean checkPalindrome(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < cleanText.length(); i++) {
            deque.addLast(cleanText.charAt(i));
        }

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }
}
