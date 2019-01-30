package medium;

public class Q82RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(head.val + 1); //overflows when head.val == Integer.MAX_VALUE
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode ptr = head;

        while (ptr != null && ptr.next != null) {
            if(ptr.val == ptr.next.val) {
                while(ptr.next.next != null && ptr.next.val == ptr.next.next.val) {
                    ptr = ptr.next;
                }
                prev.next = ptr.next.next;

                ptr = ptr.next.next;
                continue;
            }
            ptr = ptr.next;
            prev = prev.next;
        }

        return sentinel.next;
    }

/*    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode sentinel = new ListNode(-37);
        sentinel.next = head;
        int memory = head.val + 1; //initialize the value of the memory to be different from head's

        ListNode prev = sentinel;
        ListNode ptr = head;

        while (ptr != null) {
            if(memory == ptr.val) {
                prev.next = ptr.next;
                ptr = ptr.next;
            } else if (ptr.next != null && ptr.next.val == ptr.val) {
                prev.next = ptr.next.next;
                ptr = ptr.next.next;
                memory = ptr.val;
                continue;
            }
            prev = ptr;
            ptr = ptr.next;
        }
        return sentinel.next;
    }*/

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
