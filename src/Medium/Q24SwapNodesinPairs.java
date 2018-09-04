package Medium;

public class Q24SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode ptr = head;
        ListNode temp;
        ListNode headPointer = new ListNode(-37);
        headPointer.next = head;
        ListNode prev = headPointer;


        while(ptr != null && ptr.next != null) {
            prev.next = ptr.next;
            temp = ptr;
            ptr = ptr.next;
            temp.next = ptr.next;
            ptr.next = temp;
            prev = ptr.next;

            ptr = ptr.next.next;
        }
        headPointer = headPointer.next;

        return headPointer;
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
        System.out.println(swapPairs(n1));
    }
}


