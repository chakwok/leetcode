package Hard;

import helper.ListNode;

import java.util.ArrayList;
import java.util.Iterator;

public class Q23MergekSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        //create sentinel pointers pointing to the first element of each ListNode
        ArrayList<ListNode> sentinels = new ArrayList<>(lists.length);

        //Iterator<ListNode> iter = sentinels.iterator();

        ListNode head;
        for (ListNode list: lists) {
            head = new ListNode(-37);
            head.next = list;
            sentinels.add(head);
        }

        ListNode sentinelReturn = new ListNode(-37);
        ListNode ptr = sentinelReturn;

        int smallest = Integer.MAX_VALUE;
        ListNode smallestNodeSentinel = null;
        removeNodeLabel: while (sentinels.size() != 0) {
            for (ListNode sentinel : sentinels) {
                if (sentinel.next != null) {
                    if (sentinel.next.val < smallest) {
                        smallest = sentinel.next.val;
                        smallestNodeSentinel = sentinel;
                    }
                } else {
                    sentinels.remove(sentinel);
                    continue removeNodeLabel;
                }
            }

            ptr.next = smallestNodeSentinel.next;
            smallestNodeSentinel.next = smallestNodeSentinel.next.next;
            ptr = ptr.next;
            smallest = Integer.MAX_VALUE;
        }

        return sentinelReturn.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {ListNode.of(1,4,5), ListNode.of(1,3,4), ListNode.of(2,6)};
        System.out.println(mergeKLists(lists));
    }
}
