package easy;

public class Q83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode ptr = head;

        while(ptr.next != null) {
            if(ptr.next.val == ptr.val) {
                ptr.next = ptr. next.next;
                continue;
            }

            ptr = ptr.next;
        }


        return head;
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
