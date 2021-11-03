package medium;

import helper.TreeNode;

import java.util.Stack;

public class Q129SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return traverse(root, new StringBuilder());
    }


    private int traverse(TreeNode node, StringBuilder sb) {
        int sum = 0;
        sb.append(node.val);
        if(isLeaf(node)) {
            sum += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return sum;
        }

        if(node.left != null) {
            sum += traverse(node.left, sb);
        }

        if(node.right != null) {
            sum += traverse(node.right, sb);
        }
        sb.deleteCharAt(sb.length()-1);
        return sum;
    }


    //O(nlng)
    public int sumNumbersOld(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return traverse(root, new Stack<>());
    }


    private int traverse(TreeNode node, Stack<TreeNode> stack) {
        int sum = 0;
        stack.push(node);
        if(isLeaf(node)) {
            sum += sumStack(stack);
            stack.pop();
            return sum;
        }

        if(node.left != null) {
            sum += traverse(node.left, stack);
        }

        if(node.right != null) {
            sum += traverse(node.right, stack);
        }
        stack.pop();
        return sum;
    }

    private int sumStack(Stack<TreeNode> stack) {
        StringBuilder sb = new StringBuilder();
        for(TreeNode tn: stack) {
            sb.append(String.valueOf(tn.val));
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
