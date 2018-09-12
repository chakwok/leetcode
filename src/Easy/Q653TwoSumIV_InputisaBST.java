package Easy;

public class Q653TwoSumIV_InputisaBST {
    //O(nlogn)
    public static boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        } else {
            return findTargetHelper(root, k);
        }
    }

    private static boolean findTargetHelper(TreeNode node, int k) {
        if (binarySearch(node, k - node.val) && (k - node.val != node.val)) {
            return true;
        }

        if(node.left != null) {
            findTargetHelper(node.left, k);
        }
        if(node.right !=null) {
            findTargetHelper(node.right, k);
        }

        return false;
    }

    public static boolean binarySearch(TreeNode node, int l) {
        if(node == null) {
            return false;
        } else if(node.val == l) {
            return true;
        }

        if(l > node.val) {
            return binarySearch(node.right, l);
        } else {
            return binarySearch(node.left, l);
        }
        //return false;
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
    }

    public static void main(String[] args) {
        TreeNode[] nodeList= TreeNode.asList(5,3,6,2,4,0,7);
        nodeList[0].left = nodeList[1];
        nodeList[0].right = nodeList[2];
        nodeList[1].left = nodeList[3];
        nodeList[1].right = nodeList[4];
        nodeList[2].right = nodeList[6];

        boolean ans = findTarget(nodeList[0], 9);
        System.out.println(ans);
    }
}
