package easy;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }


    public static void main(String[] args) {

    }

    public boolean isSymmetricAlmost(TreeNode root) {
        if(root == null) {
            return true;
        }

        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();

        constructLeftTree(root.left, lst1);
        constructRightTree(root.right, lst2);

        if(lst1.size() != lst2.size()) {
            return false;
        } else {
            for(int i = 0; i < lst1.size(); i++) {
                if(!lst1.get(i).equals(lst2.get(i))) {
                    return false;
                }
            }
            return true;
        }

    }

    private void constructLeftTree(TreeNode node, List<Integer> lst) {
        if(node == null) {
            return;
        }
        constructLeftTree(node.left, lst);
        lst.add(node.val);
        constructLeftTree(node.right, lst);
    }

    private void constructRightTree(TreeNode node ,List<Integer> lst) {
        if(node == null) {
            return;
        }
        constructRightTree(node.right, lst);
        lst.add(node.val);
        constructRightTree(node.left, lst);
    }




}
