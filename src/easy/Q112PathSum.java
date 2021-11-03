package easy;

import helper.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Q112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        AtomicInteger refInt = new AtomicInteger();
        return traverse(root, refInt, targetSum);
    }

    private boolean traverse(TreeNode node, AtomicInteger sum, int target) {
        sum.getAndAdd(node.val);
        if(isLeaf(node)) {
            if(target == sum.get()) {
                return true;
            }
            sum.getAndAdd(-node.val);
            return false;
        }

        if(node.left != null) {
            if(traverse(node.left, sum, target)) {
                return true;
            }
        }

        if(node.right != null) {
            if(traverse(node.right, sum, target)) {
                return true;
            }
        }
        sum.getAndAdd(-node.val);
        return false;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
