
class Node {

    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UC8PalindromeChecker {

    // Main function to check if the linked list is a palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        // 3. Compare the two halves
        Node tempReversed = secondHalfHead; // Keep track to restore if needed
        while (secondHalfHead != null) {
            if (firstHalfHead.data != secondHalfHead.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        return true;
    }

    // Helper: In-place Reversal
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Utility: Convert string to Linked List
    public static Node stringToList(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current.next.prev = current; // For visualization, but this is a Singly LL
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        String input = "RADAR";
        Node head = stringToList(input);

        if (isPalindrome(head)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}
