package medium;

import helper.ListNode;

public class Q1721SwappingNodesinaLinkedList{
    public static void main(String[] args) {
        var app = new Q1721SwappingNodesinaLinkedList();
        System.out.println(app.swapNodes(ListNode.of(90,100), 2));
        System.out.println(app.swapNodes(ListNode.of(1,2,3,4,5), 2));
        System.out.println(app.swapNodes(ListNode.of(7,9,6,6,7,8,3,0,9,5), 5));
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;


        ListNode node = sentinel;
        int len = 0;
        while(node.next != null) {
            node = node.next;
            len++;
        }

        if(len % 2 == 1 && k == len / 2 + 1) {
            return sentinel.next;
        } else if (k - 1 >= len / 2) {
           k = len - k + 1;
        }

        ListNode oneBeforeFront = null;
        int back = len - k + 1;
        ListNode oneBeforeBack = null;

        node = sentinel;
        int i = 0;
        while(node.next != null) {
            if(i == k - 1) {
                oneBeforeFront = node;
            } else if(i == back - 1) {
                oneBeforeBack = node;
            }
            node = node.next;
            i++;
        }
        assert oneBeforeBack != null;
        ListNode oneAfterBack = oneBeforeBack.next.next;

        assert oneBeforeFront != null;
        if(oneBeforeFront.next == oneBeforeBack) {
            oneBeforeFront.next = oneBeforeBack.next;
            oneBeforeFront.next.next = oneBeforeBack;
            oneBeforeBack.next = oneAfterBack;
        } else {
            ListNode front = oneBeforeFront.next;
            oneBeforeFront.next = oneBeforeBack.next;
            oneBeforeFront.next.next = front.next;
            oneBeforeBack.next =  front;
            front.next = oneAfterBack;
        }
        return sentinel.next;
    }
}