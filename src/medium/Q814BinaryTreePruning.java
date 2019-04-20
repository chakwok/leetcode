package medium;

import helper.TreeNode;

public class Q814BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        if(!checkChildHasOne(root.left)) {
            root.left = null;
        } else {
            root.left = pruneTree(root.left);
        }

        if(!checkChildHasOne(root.right)) {
            root.right = null;
        } else {
            root.right = pruneTree(root.right);
        }

        return root;
    }

    private boolean checkChildHasOne(TreeNode node) {
        if(node==null) {
            return false;
        } else if(node.val == 1) {
            return true;
        } else if(node.left == null && node.right == null) {
            return false;
        }


        if (node.left != null && node.left.val == 1) {
            return true;
        }

        if(node.right != null && node.right.val == 1) {
            return true;
        }

        return checkChildHasOne(node.left)  || checkChildHasOne(node.right);
    }
}
