package medium;

import helper.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q199BinaryTreeRightSideView{
    HashMap<Integer, TreeNode> map;
    public List<Integer> rightSideView(TreeNode root) {
        map = new HashMap<>();
        helper(root, 0);
        int level = 0;
        List<Integer> out = new LinkedList<>();
        while(map.containsKey(level)) {
            out.add(map.get(level++).val);
        }
        return out;
    }

    private void helper(TreeNode node, int level) {
        if(node == null) {
            return;
        }

        if(!map.containsKey(level)) {
            map.put(level, node);
        }
        helper(node.right, level+1);
        helper(node.left, level+1);
    }
}