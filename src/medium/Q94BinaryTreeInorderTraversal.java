package medium;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while(!stack.empty()) {
            TreeNode node = stack.peek();
            while(node.left != null) {
                node = node.left;
                stack.add(node);
            }
            TreeNode first = stack.pop();
            result.add(first.val);

            if(first.right != null) {
                stack.add(first.right);
            }

        }

        return result;
//
//        while(!stack.empty()) {
//            TreeNode node = stack.pop();
//            result.add(node.val);
//        }
//
//        if(root.right!= null) {
//            stack.add(root.right);
//        }
//
//        return result;
    }
}
