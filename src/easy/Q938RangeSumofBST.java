package easy;

import helper.TreeNode;

public class Q938RangeSumofBST {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }

        if(root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if(root.left != null) {
            rangeSumBST(root.left, L, R);

        }

        if(root.right != null) {
            rangeSumBST(root.right, L, R);
        }

        return sum;
    }
}
