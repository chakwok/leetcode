package Hard;

public class Q25ReverseNodesink_Group {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-37);
        sentinel.next = head;

        ListNode prevPtr = sentinel;
        ListNode nextPtr;

        while((nextPtr = getKthChild(prevPtr, k)) != null) {
            reverseBetween(prevPtr, k);
            prevPtr = nextPtr;
            //prevPtr = getKthChild(prevPtr, k);

        }

        return sentinel.next;
    }

    private static ListNode getKthChild(ListNode node, int k) {
        if(node == null) {
            return null;
        }

        ListNode firstNode = node.next;

        while(k > 0) {
            node = node.next;
            if(node == null) {
                return null;
            }

            k--;
        }
        return firstNode;
    }

    public static ListNode reverseBetween(ListNode prev, int k) {
        ListNode start = prev.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        for(int i=0; i<k - 1; i++)
        {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return prev.next;
    }


    /*
    public ListNode reverseKGroup(ListNode head, int k) {

    }

    private ListNode reverseSubgroup(ListNode head) {

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
        System.out.println(reverseKGroup(n1, 2));
        //System.out.println(n1);
        //System.out.println(reverseBetween(n1, 2));

    }
}
