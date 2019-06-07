package medium;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q515FindLargestValueinEa {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root ==null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> save = new LinkedList<>();
        stack.add(root);
        do{
            stack.addAll(save);
            save.clear();
            int max = Integer.MIN_VALUE;
            while(!stack.empty()) {
                TreeNode node = stack.pop();

                max = Math.max(max, node.val);

                if(node.left != null) {
                    save.add(node.left);
                }
                if(node.right != null) {
                    save.add(node.right);
                }
            }
            result.add(max);
        } while(save.size() != 0);

        return result;
    }
}
