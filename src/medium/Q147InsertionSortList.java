package medium;

import helper.ListNode;

public class Q147InsertionSortList {
    // with a good trick to store both sorted head and sorted tail
    public ListNode insertionSortListBetter(ListNode head) {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode sortedHead = head, sortedTail = head;
        head = head.next;
        sortedHead.next = null;

        while (head != null)
        {
            ListNode temp = head;
            head = head.next;
            temp.next = null;

            // new val is less than the head, just insert in the front
            if (temp.val <= sortedHead.val)
            {
                temp.next = sortedHead;
                //this line is not needed, becuase when sortedHead.next only equals null when sortedHead == sorted
                //sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
                sortedHead = temp;
            }
            // new val is greater than the tail, just insert at the back
            else if (temp.val >= sortedTail.val)
            {
                sortedTail.next = temp;
                sortedTail = sortedTail.next;
            }
            // new val is somewhere in the middle, we will have to find its proper
            // location.
            else
            {
                ListNode current = sortedHead;
                while (current.next != null && current.next.val < temp.val)
                {
                    current = current.next;
                }

                temp.next = current.next;
                current.next = temp;
            }
        }

        return sortedHead;
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(-37);
        ListNode ptr;

        ListNode temp;
        while (head != null) {
            ptr = sentinel;

            while (ptr.next != null && head.val > ptr.next.val) {
                ptr = ptr.next;
            }

            if (ptr.next != null) {
                temp = ptr.next;
                ptr.next = head;
                head = head.next;
                ptr.next.next = temp;
            } else {
                ptr.next = head;
                head = head.next;
                ptr.next.next = null;
            }
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        System.out.println(insertionSortList(ListNode.of(4,2,1,3)));
    }
}
