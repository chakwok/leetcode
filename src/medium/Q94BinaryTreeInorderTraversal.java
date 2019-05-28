package medium;

import helper.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();

        stack.add(root);
        while(!stack.empty()) {
            TreeNode node = stack.peek();
            while(node.left != null && !set.contains(node.left)) {
                node = node.left;
                stack.add(node);
            }
            TreeNode first = stack.pop();
            result.add(first.val);
            set.add(first);

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


    public List<Integer> inorderTraversalElegant(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }

    public static void helper(TreeNode root, List<Integer> list){
        if(root != null){
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

}
