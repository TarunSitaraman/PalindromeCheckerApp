
public class UC2PalindromeCheckerApp {

    public static void main(String[] args) {
        String original = "madam";
        boolean isPalindrome = true;

        int i = 0;
        int j = original.length() - 1;

        while (i < j) {
            if (original.charAt(i) != original.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println("Checking string: " + original);

        if (isPalindrome) {
            System.out.println("Result: The string is a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}
