
import java.util.Stack;

class UC11_PalindromeService {

    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String cleanStr = normalize(input);
        return compareUsingStack(cleanStr);
    }

    private String normalize(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean compareUsingStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class UC11PalindromeCheckerApp {

    public static void main(String[] args) {
        UC11_PalindromeService service = new UC11_PalindromeService();

        String test1 = "Step on no pets";
        String test2 = "Hello World";

        System.out.println("Testing: " + test1);
        System.out.println("Result: " + service.checkPalindrome(test1));

        System.out.println("\nTesting: " + test2);
        System.out.println("Result: " + service.checkPalindrome(test2));
    }
}
