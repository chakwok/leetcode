package Easy;

import java.util.Stack;

//given that we are only adding elements at the end. An linkedList is perferred.
public class Q155MinStack {
    private Node head;

    /** initialize your data structure here. */
    public Q155MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public int top() {
        if (head == null) {
            return -1;
        }

        return head.val;
    }

    public int getMin() {
        if (head == null) {
            return -1;
        }

        return head.min;
    }

    private static class Node {
       private int val;
       private int min;
       private Node next;

       public Node(int val, int min, Node next) {
           this.val = val;
           this.min = min;
           this.next = next;
       }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
