package Easy;

public class Q21MergeTwoSortedLists {
    //The first element to be returned is determined by the if(l1.val < l2.val)
    //and then the l1/ l2 .next would be generated recursively and eventually the return of that if
    //will be executed to return the first element.
    //O(l1 + l2) space, O(l1 + l2) time
    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }




    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-37);
        ListNode prev = sentinel;

        while  (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                l2 = l2.next;
            } else if(l2 == null) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
            }

            prev = prev.next;
        }

        return sentinel.next;
    }


    public ListNode mergeTwoListsOld(ListNode l1, ListNode l2) { //Unfinished
        if(l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode sentinel = new ListNode(-37);
        ListNode next = sentinel;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                next.next = l2;
                l2 = l2.next;
                next = next.next;
            } else {
                next.next = l2;
            }
        }

        return sentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
