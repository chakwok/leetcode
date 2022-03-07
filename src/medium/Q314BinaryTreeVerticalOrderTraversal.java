package medium;

import helper.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q314BinaryTreeVerticalOrderTraversal{
    HashMap<Integer, List<Integer>> map;

    class TreeNodeW {
        TreeNode node;
        int level;
        public TreeNodeW(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>();
        LinkedList<TreeNodeW> curr = new LinkedList<>();
        LinkedList<TreeNodeW> next = new LinkedList<>();
        int level = 0;
        curr.add(new TreeNodeW(root, 0));


        while(curr.size() > 0) {
            while(curr.size() > 0) {
                List<Integer> lst = map.getOrDefault(level, new LinkedList<>());
                TreeNodeW w = curr.pop();
                next.add(new TreeNodeW(w.node.left, w.level -1));
                next.add(new TreeNodeW(w.node.right, w.level +1));
                map.put(level, lst);
            }

            LinkedList<TreeNodeW> tmp = curr;
            curr = next;
            next = tmp;
        }
        LinkedList<List<Integer>> out = new LinkedList<>();
        int back = -1;
        while(map.containsKey(back)) {
            out.addFirst(map.get(back--));
        }
        int front = 0;
        while(map.containsKey(front)) {
            out.addLast(map.get(front++));
        }
        return out;
    }

    private void traverseAndBuildMap(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        List<Integer> lst = map.getOrDefault(level, new LinkedList<>());
        lst.add(node.val);
        map.put(level, lst);

        traverseAndBuildMap(node.left, level - 1);
        traverseAndBuildMap(node.right, level + 1);
    }

    public List<List<Integer>> verticalOrderWrongOrder(TreeNode root) {
        map = new HashMap<>();
        traverseAndBuildMap(root, 0);

        LinkedList<List<Integer>> out = new LinkedList<>();
        int back = -1;
        while(map.containsKey(back)) {
            out.addFirst(map.get(back--));
        }
        int front = 0;
        while(map.containsKey(front)) {
            out.addLast(map.get(front++));
        }
        return out;
    }


}