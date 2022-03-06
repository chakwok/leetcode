package medium;

import helper.TreeNode;

public class Q236LowestCommonAncestorofaBinaryTree{
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverseAndGetAns(root, p.val, q.val);
        return ans;
    }

    private int traverseAndGetAns(TreeNode node, int p, int q) {
        if(ans != null) {
            return 0;
        } else if(node == null) {
            return 0;
        }

        int sum = 0;
        if(node.val == p || node.val == q) {
            sum++;
        }

        sum += traverseAndGetAns(node.left, p, q);
        sum += traverseAndGetAns(node.right, p, q);
        if(sum == 2 && ans == null) {
            ans = node;
        }
        return sum;
    }
}