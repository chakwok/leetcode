package helper;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }

    public Node(int val) {
        this.val = val;
    }
}
