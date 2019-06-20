package medium;

import helper.TreeNode;

import java.util.LinkedList;

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
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */