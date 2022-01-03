package medium;

import helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q337HouseRobberIII {
    Map<TreeNode, Integer> dpMaxChild = new HashMap<>();
    //[3,2,3,null,3,null,1] -> 7
    //[4,2,null,1,3] -> 8

    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null) {
            return root.val;
        }

        int left = rob(root.left);
        int right = rob(root.right);

        int childrenSum = left + right;
        dpMaxChild.put(root, childrenSum);

        int maxCurr = root.val + dpMaxChild.getOrDefault(root.left, 0) + dpMaxChild.getOrDefault(root.right, 0);

        return Math.max(maxCurr, left + right);
    }
}
