package easy;

public class Q876MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode ptr = head;
        while(ptr.next != null) {
            ptr = ptr.next;
            length += 1;
        }

        int toSkip = length%2 + length/2;
        ptr = head;
        for (int i = 0; i < toSkip; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }


    //Definition for singly-linked list.
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
