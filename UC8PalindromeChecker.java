
class UC8_Node {

    char data;
    UC8_Node next;

    UC8_Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UC8PalindromeChecker {

    public static boolean isPalindrome(UC8_Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        UC8_Node slow = head;
        UC8_Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        UC8_Node secondHalfHead = reverse(slow);
        UC8_Node firstHalfHead = head;

        UC8_Node p1 = firstHalfHead;
        UC8_Node p2 = secondHalfHead;
        boolean result = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        reverse(secondHalfHead);

        return result;
    }

    private static UC8_Node reverse(UC8_Node head) {
        UC8_Node prev = null;
        UC8_Node current = head;
        while (current != null) {
            UC8_Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static UC8_Node buildList(String str) {
        if (str.isEmpty()) {
            return null;
        }
        UC8_Node head = new UC8_Node(str.charAt(0));
        UC8_Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new UC8_Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        String testInput = "radar";
        UC8_Node listHead = buildList(testInput);

        if (isPalindrome(listHead)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
