
class UC9_Node {

    char data;
    UC9_Node next;

    UC9_Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UC9PalindromeCheckerApp {

    private UC9_Node left;

    public boolean isPalindrome(UC9_Node head) {
        left = head;
        return check(head);
    }

    private boolean check(UC9_Node right) {
        if (right == null) {
            return true;
        }

        boolean res = check(right.next);
        if (!res) {
            return false;
        }

        boolean match = (left.data == right.data);
        left = left.next;

        return match;
    }

    public static UC9_Node buildList(String str) {
        if (str.isEmpty()) {
            return null;
        }
        UC9_Node head = new UC9_Node(str.charAt(0));
        UC9_Node curr = head;
        for (int i = 1; i < str.length(); i++) {
            curr.next = new UC9_Node(str.charAt(i));
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        UC9PalindromeCheckerApp checker = new UC9PalindromeCheckerApp();
        UC9_Node head = buildList("level");

        if (checker.isPalindrome(head)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
