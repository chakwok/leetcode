package easy;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0 , result);
        Collections.reverse(result);

        return result;


    }

    private void helper(TreeNode node, int depth, List<List<Integer>> result) {
        if(node == null ) {
            return;
        }

        if(depth < result.size()) {
            result.get(depth).add(node.val);
        } else {
            List<Integer> lst = new LinkedList<Integer>();
            lst.add(node.val);
            result.add(lst);
        }

        helper(node.left, depth + 1, result);
        helper(node.right, depth + 1, result);
    }
}
