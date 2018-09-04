package Hard;

public class Q25ReverseNodesink_Group {/*
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
}
