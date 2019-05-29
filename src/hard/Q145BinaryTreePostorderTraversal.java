package hard;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        if(root == null) {
            return lst;
        }
        helper(root, lst);
        return lst;
    }

    private void helper(TreeNode node, List<Integer> lst) {
        if(node == null) {
            return;
        }
        helper(node.left, lst);
        helper(node.right, lst);
        lst.add(node.val);
    }
}
