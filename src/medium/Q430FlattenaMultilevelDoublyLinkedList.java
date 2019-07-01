package medium;

import helper.Node;

import java.util.Stack;

public class Q430FlattenaMultilevelDoublyLinkedList {
    /*public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node ptr = head;

        while(ptr != null) {
            if(ptr.child != null) {

            }
        }


        return head;
    }*/

    public Node flatten(Node head) {
        flattenTail(head); // modified the list
        return head;
    }

    // flatten and remove the last element
    public Node flattenTail(Node head) {
        if(head == null || head.next == null && head.child == null) {
            return head;
        }

        Node ptr = head;
        Node prev = new Node();
        prev.next = head;

        while(ptr != null) {
            if(ptr.child != null) {
                Node temp = ptr.next;

                ptr.next = ptr.child;
                ptr.child.prev = ptr;

                Node tail = flattenTail(ptr.child);

                if(temp != null) {
                    temp.prev = tail;
                    temp.prev.next = temp;
                }

                ptr.child = null;

                prev = tail;
                ptr = temp;
            } else {
                prev = ptr;
                ptr = ptr.next;
            }
        }

        return prev;

    }


}
