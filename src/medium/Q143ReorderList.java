package medium;

import helper.ListNode;

import java.util.ArrayList;
 import java.util.LinkedList;

public class Q143ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ArrayList<ListNode> lst = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            lst.add(curr);
            ListNode prev = curr;
            curr = curr.next;
            prev.next = null;
        }

        int front = 0;
        int back = lst.size() - 1;


        boolean fromStart = true;
        while(front != back) {
            if(fromStart) {
                lst.get(front++).next = lst.get(back);
            } else {
                lst.get(back--).next = lst.get(front);
            }
            fromStart = !fromStart;
        }

    }

    public static void main(String[] args) {
        new Q143ReorderList().reorderList(ListNode.of(1,2,3,4));
    }
}
