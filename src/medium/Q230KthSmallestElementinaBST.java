package medium;

import helper.TreeNode;

import java.util.Stack;

public class Q230KthSmallestElementinaBST {
    public static void main(String[] args) {
//        TreeNode[] nodes = TreeNode.asList(3,1,4,2);
//        TreeNode root = nodes[0];
//        root.left = nodes[1];
//        root.right = nodes[2];
//        nodes[1].right = nodes[3];

        TreeNode[] nodes = TreeNode.asList(5,3,6,2,4,1);
        TreeNode root = nodes[0];
        root.left = nodes[1];
        root.right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[3].left = nodes[5];

        var app = new Q230KthSmallestElementinaBST();
        System.out.println(app.kthSmallest(root, 3));
    }

    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        TreeNode node =  helper(root);
        return node.val;

    }

    private TreeNode helper(TreeNode node) {
        if(node == null) {
            return null;
        }


        TreeNode left = helper(node.left);
        if(left != null) {
            return left;
        }
        if(k-- == 1) {
            return node;
        }

        TreeNode right = helper(node.right);
        if(right != null) {
            return right;
        }
        return null;
    }

    public int kthSmallestIterative(TreeNode root, int k) {
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
