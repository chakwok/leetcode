package hard

import helper.TreeNode

class Q124BinaryTreeMaximumPathSum {
    class Solution {
        var max = Int.MIN_VALUE;
        fun maxPathSum(root: TreeNode?): Int {
            helper(root);
            return max;
        }

        fun helper(root: TreeNode?): Int {
            if(root == null) {
                return 0;
            }

            val currLeftMax = helper(root.left);
            var currRightMax = helper(root.right);

            var currMax = root.`val`;
            if(currLeftMax > 0) {
                currMax += currLeftMax
            }
            if(currRightMax > 0) {
                currMax += currRightMax;
            }
            max = maxOf(max, currMax);

            return maxOf(root.`val`, maxOf(root.`val` + currLeftMax, root.`val` + currRightMax))
            /*return currMax;*/
        }
    }


}