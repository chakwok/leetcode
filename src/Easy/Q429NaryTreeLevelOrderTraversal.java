package Easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q429NaryTreeLevelOrderTraversal {
/*
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<Node> currLevel = new LinkedList<>();
        List<Node> nextLevel = new LinkedList<>();
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();

        currLevel.add(root);

        for (Node node : currLevel) {
            List<Integer> intList = new LinkedList<>();
            intList.add(node.val);

        }
        toReturn.add(intList);

        return toReturn;
    }
*/


    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<Node> currLevel = new LinkedList<>();
        List<Node> nextLevel = new LinkedList<>();
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();

        currLevel.add(root);

        while(!currLevel.isEmpty()) {
            List<Integer> intList = new LinkedList<>();

            Node node;
            while (!currLevel.isEmpty()) {
                node = ((LinkedList<Node>) currLevel).removeFirst();
                intList.add(node.val);
                if(node.children!= null) {
                    nextLevel.addAll(node.children);
                }
            }
            toReturn.add(intList);
            currLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }


/*
        while(!currLevel.isEmpty()) {
            List<Integer> intList = new LinkedList<>();

            Iterator<Node> iter = currLevel.iterator();

            Node node;
            while (iter.hasNext()) {
                node = ((LinkedList<Node>) currLevel).removeFirst();
                intList.add(node.val);
                if(node.children!= null) {
                    nextLevel.addAll(node.children);
                }
            }
            toReturn.add(intList);
            currLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }
*/



        return toReturn;
    }

    public static void main(String[] args) {
        List<Node> child = new LinkedList<>();
        List<Node> child2 = new LinkedList<>();
        child2.add(new Node(5, null));
        child2.add(new Node(6, null));
        child.add(new Node(3, child2));
        child.add(new Node(2, null));
        child.add(new Node(4, null));

        Node root = new Node(1, child);
        System.out.println(levelOrder(root));
    }
/*
    public void printLevel(List<Integer> lst) {

    }*/

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }

        public List<Node> getChiledren() {
            return new LinkedList<Node>(children);
        }
    };

}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
