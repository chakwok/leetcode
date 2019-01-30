package easy;

public class Q617MergeTwoBinaryTrees {
    //Time complexity M, minimun number of node in the tree
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) //implies if both null, return null
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        //avoid building a new tree
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //Time complexity N
    public TreeNode mergeTreesOld(TreeNode t1, TreeNode t2) {
        //TreeNode node = new TreeNode();
        if(t1 == null) {
            return t2;
        } else if(t2 == null) {
            return t1;
        }

        return mergeTreesHelper(t1, t2);
    }

    private TreeNode mergeTreesHelper(TreeNode t1, TreeNode t2) {
        //base case
        if(t1 == null && t2 == null) {
            return null;
        }

        //current node
        TreeNode node;
        //int nodeVal = (t1 == null? t2.val: (t2 == null)? t1.val: t1.val + t2.val);
        if (t1 == null) {
            node = new TreeNode(t2.val);
            node.left = mergeTreesHelper(null, t2.left);
            node.right = mergeTreesHelper(null, t2.right);
        } else if (t2 == null) {
            node = new TreeNode(t1.val);
            node.left = mergeTreesHelper(t1.left, null);
            node.right = mergeTreesHelper(t1.right, null);
        } else {
            node = new TreeNode(t1.val + t2.val);
            node.left = mergeTreesHelper(t1.left, t2.left);
            node.right = mergeTreesHelper(t1.right, t2.right);
        }

        return node;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
