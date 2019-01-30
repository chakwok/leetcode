package medium;


public class Q92ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode(-37);
        sentinel.next = head;

        ListNode ptrOneBefore = sentinel;
        ListNode ptrOneAfter = sentinel;

        for(int i = 0; i < n; i++) {
            if(i < m - 1){
                ptrOneBefore = ptrOneBefore.next;
            }
            ptrOneAfter = ptrOneAfter.next;
        }
        ptrOneAfter = ptrOneAfter.next;

        ListNode prevHead = ptrOneBefore.next; //New reverse tail
        ListNode prevTail = reverseHelper(ptrOneBefore.next, n - m); //reverse is done after this line

        ptrOneBefore.next = prevTail;
        prevHead.next = ptrOneAfter;

//        prevHead.next = ptrOneAfter;
//        prevHead.next = prevTail;

        return sentinel.next;
    }
    /**
     * @Return: return prev tail.
     * */
    public static ListNode reverseHelper(ListNode node, int toReverse) {
        //Need to use the property of prev.next of stack trace
        //base case num = 0
        if(toReverse == 0) {
            return node;
        }

        ListNode toReturn = reverseHelper(node.next, toReverse - 1);
        node.next.next = node;
        node.next = null;
        return toReturn;
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


    public static ListNode reverseBetweenIte(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }


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
        System.out.println(reverseBetweenIte(n1, 1, 5));
    }

/*    public static ListNode reverse(ListNode curr) {
        if (curr.next == null) {
            return curr;
        }

        return reverse(curr.next).next = curr;
    }*/
}
