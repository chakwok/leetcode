package medium;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Q230KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(root.left != null) {
            stack.push(root.left);
            root = root.left;
        }

        while(true) {
            TreeNode node = stack.pop();

            if(k-- == 1) {
                return node.val;
            }

            if(node.right != null) {
                stack.push(node.right);
                node = node.right;
                while(node.left != null) {
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }
    }


}
