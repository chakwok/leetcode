package medium;

public class Q1650LowestCommonAncestorofaBinaryTreeIII{
    public Node lowestCommonAncestor(Node p, Node q) {
        Node m1 = p;
        Node m2 = q;
        while(m1 != null) {
            if(m1 == m2) {
                return m1;
            }
            m1 = (m1.parent != null)? m1.parent : q;
            m2 = (m2.parent != null)? m2.parent : p;
        }
        return m1;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}

