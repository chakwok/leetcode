package Medium;

import java.util.Arrays;

public class Q725SplitLinkedListinParts {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodeArray = new ListNode[k];
        int[] listNodesSize = new int[k];

        int listSize = getSize(root);

        int normalSize = listSize / k;
        int listWithExtraOne = listSize % k;

        for(int i = 0; i < k; i++) {
            if (listWithExtraOne != 0) {
                listNodesSize[i] = normalSize + 1;
            } else {
                listNodesSize[i] = normalSize;
                 continue;
            }
            listWithExtraOne -= 1;
        }

        for(int i = 0; i < k; i++ ) {
            int innerCount = listNodesSize[i];
            ListNode dummy = new ListNode(-37);
            nodeArray[i] = dummy;
            for(int j = 0; j < innerCount; j++) {
                dummy.next = root;
                root = root.next;
                dummy = dummy.next;
                dummy.next = null;
            }
            nodeArray[i] = nodeArray[i].next;
        }

        return nodeArray;
    }

    public static int getSize(ListNode root) {
        int count = 0;
        while(root != null) {
            count += 1;
            root = root.next;
        }
        return count;
    }

//    This split will split [1,2,3,4] , 2 like this [[1,3], [2,4]]
 /*   public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodeArray = new ListNode[k];
        ListNode[] lastElement = new ListNode[k];

        for(int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(-37);
            nodeArray[i] = dummy;
            lastElement[i] = dummy;
        }

        ListNode ptr = root;
        int count = 0;
        while(ptr != null) {
            ListNode temp = ptr;
            ptr = ptr.next;
            temp.next = null;
            lastElement[count % k].next = temp;
            lastElement[count % k] = temp;

            count += 1;
        }
        for(int i = 0; i < k; i++) {
            nodeArray[i] = nodeArray[i].next;
        }


        return nodeArray;
    }*/

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
        ListNode[] arr = splitListToParts(n1, 2);
        System.out.println(Arrays.deepToString(arr));
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
}
