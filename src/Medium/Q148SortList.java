package Medium;

import helper.ListNode;

import java.util.ArrayList;

public class Q148SortList {
    //mergeSort
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oneHalf = new ListNode(-37);
        ListNode ptrOne = oneHalf;
        ListNode secondHalf = new ListNode(-37);
        ListNode ptrTwo = secondHalf;

        while (head != null) {
            ptrOne.next = head;
            ptrTwo.next = head.next;

            if (ptrTwo.next == null) {
                break;
            }
            head = head.next.next;
            ptrOne = ptrOne.next;
            ptrOne.next = null;
            ptrTwo = ptrTwo.next;
            ptrTwo.next = null;
        }

        return mergeTwoLists(mergeSort(oneHalf.next), mergeSort(secondHalf.next));
    }

    //reuse code from Q23, the running time is Nlog(k) where k is the number of already sorted nodeLists
    // in the ListNode list. space: O(n)
    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<ListNode> nodeList = new ArrayList<>();

        ListNode ptr = head;
        ListNode pause = head;

        while (ptr != null) {
            if (ptr.next != null && ptr.next.val > ptr.val) {
                ptr = ptr.next;
            } else {
                nodeList.add(pause);
                pause = ptr.next;
                ptr.next = null;
                ptr = pause;
            }
        }

        ListNode[] nodeArr = new ListNode[nodeList.size()];
        nodeArr = nodeList.toArray(nodeArr);

        return mergeKLists(nodeArr);
    }

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

    public static void main(String[] args) {
        System.out.println(sortList(ListNode.of(4, 2, 1, 3)));
    }

}

