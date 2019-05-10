package easy;

import helper.TreeNode;

public class Q965UnivaluedBinaryTree {
    boolean isUniValue = true;
    int rootValue;
    public boolean isUnivalTree(TreeNode root) {
        rootValue = root.val;
        checkValue(root);
        return isUniValue;
    }

    private void checkValue(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.val != rootValue) {
            isUniValue = false;
        }

        if(node.left != null) {
            checkValue(node.left);
        }

        if(node.right != null) {
            checkValue(node.right);
        }
    }
}
