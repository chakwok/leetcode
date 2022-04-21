package medium;

import helper.TreeNode;

public class Q99RecoverBinarySearchTree{
    public static void main(String[] args) {
        var app = new Q99RecoverBinarySearchTree();
/*        TreeNode[] nodes = TreeNode.asList(1,3,2);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[2];
        app.recoverTree(nodes[0]);*/

        TreeNode[] nodes = TreeNode.asList(3,1,4,2);
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[2].left = nodes[3];
        app.recoverTree(nodes[0]);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);


    private boolean inorder(TreeNode node) {
        if(node == null) {
            return false;
        }

        if(inorder(node.left)) {
            return true;
        }
        if(node.val < prev.val) {
            if(first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
                return true; //early termination
            }
        }
        prev = node;
        if(inorder(node.right)) {
            return true;
        }
        return false;
    }


}