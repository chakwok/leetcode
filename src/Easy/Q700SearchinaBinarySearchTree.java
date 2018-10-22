package Easy;

public class Q700SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else if (root.val == val){
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
