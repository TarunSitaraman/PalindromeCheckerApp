
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// 1. Define the Strategy Interface
interface PalindromeStrategy {

    boolean isValid(String input);
}

// 2. Implement StackStrategy (LIFO approach)
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) {
            stack.push(c);
        }
        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// 3. Implement DequeStrategy (Two-ended approach)
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// 4. Context Class (The Service)
class PalindromeService {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isValid(text);
    }
}

// 5. App Class
public class UC12PalindromeCheckerApp {

    public static void main(String[] args) {
        PalindromeService service = new PalindromeService();
        String testInput = "Race Car";

        // Inject Stack Strategy
        service.setStrategy(new StackStrategy());
        System.out.println("Using Stack: " + service.check(testInput));

        // Inject Deque Strategy at Runtime
        service.setStrategy(new DequeStrategy());
        System.out.println("Using Deque: " + service.check(testInput));
    }
}
