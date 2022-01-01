package medium;

import helper.ListNode;

public class Q328OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        ListNode oddSentinel = new ListNode();
        ListNode evenSentinel = new ListNode();

        boolean isOdd = true;
        ListNode odds = oddSentinel;
        ListNode evens = evenSentinel;
        while(head != null) {
            if(isOdd) {
                odds.next = head;
                odds = odds.next;
            } else {
                evens.next = head;
                evens = evens.next;
            }

            isOdd = !isOdd;
            head = head.next;
        }

        evens.next = null;
        odds.next = evenSentinel.next;

        return oddSentinel.next;
    }

    //iter
    public static ListNode oddEvenListOld(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddsHead = new ListNode(-37);
        ListNode evensHead = new ListNode(-37);

        ListNode odds = oddsHead;
        ListNode evens = evensHead;

        while(head != null && head.next != null) {
            odds.next = head;
            evens.next = head.next;

            head = head.next.next;
            odds = odds.next;
            evens = evens.next;
        }
        odds.next = null;
        evens.next = null;

        if(head != null) {
            odds.next = head;
            odds = odds.next;
        }

        odds.next = evensHead.next;

        return oddsHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1,2,3,4,5);
        ListNode ans = oddEvenList(head);
        System.out.println(ans);
    }


    //recur
}
