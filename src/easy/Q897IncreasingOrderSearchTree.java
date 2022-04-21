package easy;

import helper.TreeNode;

public class Q897IncreasingOrderSearchTree{
    public static void main(String[] args) {
        var app = new Q897IncreasingOrderSearchTree();
        TreeNode[] nodes = TreeNode.asList(2,1,4,3);
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[2].left = nodes[3];
        app.increasingBST(nodes[0]);
    }

    TreeNode prev = new TreeNode();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode sentinel = prev;
          traverse(root);
//          prev.left = null;
          return sentinel.right;
    }

    private void traverse(TreeNode node) {
        if(node == null) {
            return;
        } /*else if(node.left == null && first == null) {
            first = node;
        }*/
        traverse(node.left);
        prev.right = node;
        prev = prev.right;
        prev.left = null;
        traverse(node.right);
    }

    /*public TreeNode increasingBST(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode left = increasingBST(root.left);
        root.left = null;
        if(left != null) {
            //left.left = null;
            left.right = root;
        }
        root.right = increasingBST(root.right);
        return root.right != null? root.right : root;
    }*/
}