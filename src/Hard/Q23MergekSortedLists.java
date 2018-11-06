package Hard;

import helper.ListNode;

import java.util.ArrayList;
import java.util.Iterator;

public class Q23MergekSortedLists {
    //runtime: O(nlnk), space: O(1)
    public static ListNode mergeKLists(ListNode[] lists) {
        //terminating case
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        //if lists.length is odd, merge the last two
        // listsRemaining is by index
        int remaining = lists.length - 1;

        while (remaining != 0) {
            //if remaining is odd(but remaining is 0-indexed, merge the last two
            if (remaining % 2 == 0) {
                lists[remaining - 1] = mergeTwoLists(lists[remaining - 1], lists[remaining]);
                //lists[remaining] = null;
                remaining--;
            }

            for (int i = 0; i < (remaining + 1) / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[remaining - i]);
            }
            remaining /= 2;
        }

        return lists[0];
    }

    //runtime: O(l1 + l2), space: O(1)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-37);
        ListNode prev = sentinel;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
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

    //runtime: O(nm), not extra data structure used; the runtime is still slow like 100ms, beating 16% submissions
    //it's quicker as it eliminates reluctant comparison when there's not elements in a list
    public static ListNode mergeKListsOld(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        ListNode sentinel = new ListNode(-37);
        ListNode ptr = sentinel;

        int smallest;
        int smallestIndex = 0;

        // a variable to determine the range to check; reduce the runtime to O(n) instead of O(mn)
        int checkRange = lists.length - 1;

        label:
        while (checkRange >= 0) {
            smallest = Integer.MAX_VALUE;
            for (int i = 0; i <= checkRange; i++) {
                if (lists[i] == null) {
                    ListNode temp = lists[checkRange];
                    lists[checkRange] = lists[i];
                    lists[i] = temp;

                    checkRange--;
                    continue label;
                }

                if (lists[i].val < smallest) {
                    smallest = lists[i].val;
                    smallestIndex = i;
                }

            }

            ptr.next = lists[smallestIndex];
            ptr = ptr.next;
            lists[smallestIndex] = lists[smallestIndex].next;
        }

        return sentinel.next;
    }

    //306ms. beats 7% submissions
    //runtime: O(nm) where n is the number of elements, m is the size of the lists
    public static ListNode mergeKListsSlow2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        ListNode sentinel = new ListNode(-37);
        ListNode ptr = sentinel;

        int smallest;
        int smallestIndex = 0;

        while (true) {
            smallest = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (lists[i].val < smallest) {
                    smallest = lists[i].val;
                    smallestIndex = i;
                }

            }

            if (smallest == Integer.MAX_VALUE) {
                break;
            }

            ptr.next = lists[smallestIndex];
            ptr = ptr.next;
            lists[smallestIndex] = lists[smallestIndex].next;
        }

        return sentinel.next;
    }

    //596ms. Bottom 1% runtime;
    //runtime: O(nm) where n is the number of elements, m is the size of the lists
    public static ListNode mergeKListsSlow(ListNode[] lists) {
        //create sentinel pointers pointing to the first element of each ListNode
        ArrayList<ListNode> sentinels = new ArrayList<>(lists.length);

        //Iterator<ListNode> iter = sentinels.iterator();

        ListNode head;
        for (ListNode list : lists) {
            head = new ListNode(-37);
            head.next = list;
            sentinels.add(head);
        }

        ListNode sentinelReturn = new ListNode(-37);
        ListNode ptr = sentinelReturn;

        int smallest = Integer.MAX_VALUE;
        ListNode smallestNodeSentinel = null;
        removeNodeLabel:
        while (sentinels.size() != 0) {
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
        ListNode[] lists = new ListNode[]{ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)};
        System.out.println(mergeKListsSlow(lists));
    }
}
