package Easy;

public class Q206ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next; //get the lastNode as the new head
        }

        reverseHelper(head).next = null; //explicitly change the .next of the first node to null

        return ptr;
    }

    public static ListNode reverseHelper(ListNode curr) {
        if (curr.next == null) {
            return curr; //base case, return the last null
        }

        reverseHelper(curr.next).next = curr; //didn't use the property of prev.next. see methodRec
        return curr;
    }

    public static ListNode reverseListIte(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp;
        ListNode prev = null;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next); //the last node p is memorized and returned from and to
                                            //  every stack trace.
        head.next.next = head; //making use of the property of curr.next of prev stack
        head.next = null;
        return p;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseListRec(n1));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String toReturn = "[" + Integer.toString(val);
            ListNode ptr = next;
            while (ptr != null) {
                toReturn += "," + ptr.val;
                ptr = ptr.next;
            }
            toReturn += "]";
            return toReturn;
        }
    }
}
