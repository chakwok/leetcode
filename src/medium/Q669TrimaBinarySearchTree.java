package medium;

import helper.TreeNode;

public class Q669TrimaBinarySearchTree{
    public TreeNode trimBST(TreeNode root, int low, int high) {
//        TreeNode sentinel = new TreeNode();
//        root.right = root;
        return helper(root, low, high);
    }

    private TreeNode helper(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        } else if(root.val > high) {
            return helper(root.left, low, high);
        } else if(root.val < low) {
            return helper(root.right, low, high);
        }

        root.left = helper(root.left, low, high);
        root.right = helper(root.right, low, high);
        return root;
    }
}