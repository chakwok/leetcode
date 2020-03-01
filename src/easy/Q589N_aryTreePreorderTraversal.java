package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Q589N_aryTreePreorderTraversal {
    public List<Integer> preorderIte(Node root) {
        List<Integer> ans = new LinkedList<Integer>();
        if(root == null) {
            return ans;
        }

        Stack<Node> queue = new Stack<>();
        queue.push(root);
        while(queue.size() > 0) {
            Node node = queue.pop();
            ans.add(node.val);

            for(int i = node.children.size() - 1; i >= 0; i--) {
                queue.push(node.children.get(i));
            }
        }

        return ans;
    }

    //recursive
    public List<Integer> preorderRec(Node root) {
        List<Integer> ans = new LinkedList<Integer>();
        traverse(root, ans);
        return ans;
    }

    private void traverse(Node node, List<Integer> ans) {
        if(node == null) {
            return;
        }

        ans.add(node.val);

        for(int i = 0; i < node.children.size(); i++) {
            traverse(node.children.get(i), ans);
        }
    }

    public static void main(String[] args) {
        Q589N_aryTreePreorderTraversal app = new Q589N_aryTreePreorderTraversal();
//        app.preorder()
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
