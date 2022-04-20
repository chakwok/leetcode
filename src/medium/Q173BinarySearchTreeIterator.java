package medium;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class Q173BinarySearchTreeIterator {
    LinkedList<Integer> lst;

    public Q173BinarySearchTreeIterator(TreeNode root) {
        lst = new LinkedList<Integer>();
        helper(root);
    }

    private void helper(TreeNode node) {
        if(node == null ) {
            return;
        }
        helper(node.left);
        lst.add(node.val);
        helper(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        return lst.removeFirst();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return lst.size() > 0;
    }

    class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            addSubTreeLeft(root);
        }

        private void addSubTreeLeft(TreeNode node) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode pop = stack.pop();
            addSubTreeLeft(pop.right);
            return pop.val;
        }

        public boolean hasNext() {
            return stack.size() > 0;
        }
    }

}

//BST
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


/*
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    */
/** @return whether we have a next smallest number *//*

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    */
/** @return the next smallest number *//*

    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}*/
