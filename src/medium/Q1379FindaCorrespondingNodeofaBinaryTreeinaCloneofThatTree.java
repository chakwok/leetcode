package medium;

import helper.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

public class Q1379FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
    enum Direction {
        LEFT, RIGHT
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(target == null || original == null) {
            return null;
        }

        LinkedList<Direction> path = getPathToElement(original, target);
        return getElementFromPath(cloned, path);
    }

    private TreeNode getElementFromPath(TreeNode root, LinkedList<Direction> path) {
        TreeNode node = root;
        for(Direction dir: path) {
            if(dir == Direction.LEFT) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    private LinkedList<Direction> getPathToElement(TreeNode node, TreeNode target) {
        LinkedList<Direction> path = new LinkedList<>();
        getPathToElement(node, target, path, null);
        path.removeLast();
        Collections.reverse(path);
        return path;
    }

    private boolean getPathToElement(TreeNode node, TreeNode target, LinkedList<Direction> path, Direction direction) {
        if(node == target) {
            path.add(direction);
            return true;
        }

        if(node.left != null) {
            boolean leftResult = getPathToElement(node.left, target, path, Direction.LEFT);
            if(leftResult) {
                path.add(direction);
                return true;
            }
        }

        if(node.right != null) {
            boolean rightResult = getPathToElement(node.right, target, path, Direction.RIGHT);
            if(rightResult) {
                path.add(direction);
                return true;
            }
        }

        return false;
    }

}
