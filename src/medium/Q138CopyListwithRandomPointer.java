package medium;

import helper.Node;

import java.util.HashMap;
import java.util.Map;

public class Q138CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cloneHead = new Node(head.val);

        Node curr = head;
        Node cloneCurr = cloneHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(curr, cloneCurr);


        curr = curr.next;
        while (curr != null) {
            Node clone = new Node(curr.val);
            map.put(curr, clone);

            cloneCurr.next = clone;
            cloneCurr = cloneCurr.next;
            curr = curr.next;
        }

        curr = head;
        cloneCurr = cloneHead;

        while (curr != null) {
            cloneCurr.random = map.get(curr.random);

            cloneCurr = cloneCurr.next;
            curr = curr.next;
        }


        return cloneHead;
    }
}

