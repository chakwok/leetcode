package Medium;

public class Q92ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }

        ListNode newHead;

        return null;
    }
/*    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-37);
        dummy.next = head;

        ListNode ptr = dummy;

        for(int i = 0; i < m; i++) {
            ptr = ptr.next;
        }

        ptr.next = reverseHelper(ptr.next, n - m);

        return head;
    }

    *//**Return the last Node of the reversed list. The old first node is pointing to n+1th node*//*
    private static ListNode reverseHelper(ListNode curr, int k) {
        if(k == 0) {
            return curr;
        }

        reverseHelper(curr.next, k - 1).next = curr;
        return curr;

    }*/

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            String toReturn = "[" + Integer.toString(val);
            ListNode ptr = next;
            while(ptr != null) {
                toReturn += "," + ptr.val;
                ptr = ptr.next;
            }
            toReturn += "]";
            return toReturn;
        }
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
        //System.out.println(reverse(n1));
    }

/*    public static ListNode reverse(ListNode curr) {
        if (curr.next == null) {
            return curr;
        }

        return reverse(curr.next).next = curr;
    }*/
}
