package easy;

import helper.TreeNode;

public class Q563BinaryTreeTilt {
    //[4,2,9,3,5,null,7]
    int sum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sumLeft = helper(root.left);
        int sumRight = helper(root.right);

        if(root.left == null && root.right == null) {
            sum += 0;
        } else if(root.left == null) {
            sum += Math.abs(sumRight);
        } else if(root.right == null) {
            sum += Math.abs(sumLeft);
        } else {
            sum += Math.abs(sumRight - sumLeft);
        }

        return root.val + sumLeft + sumRight;
    }
}
