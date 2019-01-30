package easy;

public class Q104MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left) + 1;
        int maxRight = maxDepth(root.right) + 1;
        return Math.max(maxLeft, maxRight) ;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public static TreeNode[] asList(int... xs) {
            TreeNode[] toReturn = new TreeNode[xs.length];
            for(int i = 0; i < xs.length; i++) {
                toReturn[i] = new TreeNode(xs[i]);
            }
            return toReturn;
        }

        @Override
        public String toString() {
            return String.format("[%s]", val);
        }
    }

    public static void main(String[] args) {
        TreeNode[] nodeList= TreeNode.asList(5,3,6,2,4,0,7);
        nodeList[0].left = nodeList[1];
        nodeList[0].right = nodeList[2];
        nodeList[1].left = nodeList[3];
        nodeList[1].right = nodeList[4];
        nodeList[2].right = nodeList[6];

        System.out.println(maxDepth(nodeList[0]));
    }
}
