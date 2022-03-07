package medium;



public class Q426ConvertBinarySearchTreetoSortedDoublyLinkedList{
    Node sentinel;
    Node last;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        sentinel = new Node();
        last = sentinel;
        dfsBuildForwardNode(root);

        Node node = sentinel.right;
        while(node.right != null) {
            node = node.right;
        }

        sentinel.right.left = node;
        node.right = sentinel.right;
        return sentinel.right;
    }

    private void dfsBuildForwardNode(Node node) {
        if(node == null) {
            return;
        }

        dfsBuildForwardNode(node.left);
        last.right = node;
        node.left = last;
        last = last.right;

        dfsBuildForwardNode(node.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};