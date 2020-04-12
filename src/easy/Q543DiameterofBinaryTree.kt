package easy

import helper.TreeNode

class Q543DiameterofBinaryTree {
    var max = 0;

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null) {
            return 0;
        }

        getHeightNUpdateMax(root);

        return max;
    }

    private fun getHeightNUpdateMax(node : TreeNode?): Int {
        if(node == null) {
            return 0;
        } else if(node.left == null && node.right == null) {
            return 1;
        }

        var hl = getHeightNUpdateMax(node.left);
        var hr = getHeightNUpdateMax(node.right);
        max = maxOf(max, hl + hr);

        return maxOf(hl, hr) + 1
    }
}