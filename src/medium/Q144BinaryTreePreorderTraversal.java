package medium;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) {
            return list;
        }
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
    }
}
