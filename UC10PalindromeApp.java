
class UC10_Node {

    char data;
    UC10_Node next;

    UC10_Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UC10PalindromeApp {

    public static String normalize(String str) {
        if (str == null) {
            return "";
        }
        // Removes all non-alphanumeric characters and converts to lowercase
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static UC10_Node buildList(String str) {
        String cleanStr = normalize(str);
        if (cleanStr.isEmpty()) {
            return null;
        }

        UC10_Node head = new UC10_Node(cleanStr.charAt(0));
        UC10_Node curr = head;
        for (int i = 1; i < cleanStr.length(); i++) {
            curr.next = new UC10_Node(cleanStr.charAt(i));
            curr = curr.next;
        }
        return head;
    }

    public static boolean isPalindrome(UC10_Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Using the UC8 Fast/Slow pointer logic
        UC10_Node slow = head;
        UC10_Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        UC10_Node secondHalf = reverse(slow);
        UC10_Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static UC10_Node reverse(UC10_Node head) {
        UC10_Node prev = null;
        UC10_Node curr = head;
        while (curr != null) {
            UC10_Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Test Case: "A man a plan a canal Panama"
        String input = "A man, a plan, a canal: Panama";
        UC10_Node head = buildList(input);

        System.out.println("Original: " + input);
        System.out.println("Normalized: " + normalize(input));

        if (isPalindrome(head)) {
            System.out.println("Result: True");
        } else {
            System.out.println("Result: False");
        }
    }
}
