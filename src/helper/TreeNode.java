package helper;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode[] asList(int... xs) {
        TreeNode[] toReturn = new TreeNode[xs.length];
        for(int i = 0; i < xs.length; i++) {
            toReturn[i] = new TreeNode(xs[i]);
        }
        return toReturn;
    }
}
