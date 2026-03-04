
import java.util.*;

interface UC13_Strategy {

    boolean check(String s);
}

class UC13_Iterative implements UC13_Strategy {

    public boolean check(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

class UC13_Stack implements UC13_Strategy {

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class UC13_Recursive implements UC13_Strategy {

    public boolean check(String s) {
        return helper(s, 0, s.length() - 1);
    }

    private boolean helper(String s, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }
        return helper(s, l + 1, r - 1);
    }
}

public class UC13PerformanceApp {

    public static void measure(String name, UC13_Strategy strategy, String input) {
        long start = System.nanoTime();
        boolean result = strategy.check(input);
        long end = System.nanoTime();
        System.out.printf("%-12s | Result: %-6s | Time: %d ns%n", name, result, (end - start));
    }

    public static void main(String[] args) {
        String testInput = "racecar".repeat(100); // Larger input for better measurement

        System.out.println("Algorithm Comparison (Input Length: " + testInput.length() + ")");
        System.out.println("---------------------------------------------------------");

        measure("Iterative", new UC13_Iterative(), testInput);
        measure("Stack", new UC13_Stack(), testInput);
        measure("Recursive", new UC13_Recursive(), testInput);
    }
}
