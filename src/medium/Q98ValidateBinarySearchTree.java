package medium;

import helper.TreeNode;

import java.util.Stack;

public class Q98ValidateBinarySearchTree {

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

/*
    boolean isValid = true;
    // O(n) runtime, O(1) space
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        validateBST(root);

        return isValid;
    }

    private void validateBST(TreeNode) {

    }
*/



    /*private boolean validateBST(TreeNode node) {
        if(node == null) {
            return true;
        }

        if(node.left != null && node.left.val >= node.val) {
            return false;
        } else if(node.right != null && node.right.val <= node.val) {
            return false;
        } else {

        }
    }*/

    /*private boolean validateBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();

            if(node.left != null) {
                if(node.left.val >= node.val) {
                    return false;
                } else {
                    stack.push(node.left);
                }

            } else if(node.right != null) {
                if(node.right.val <= node.val) {
                    return false;
                } else {
                    stack.push(node.right);
                }
            }
        }
        return true;
    }*/

}
