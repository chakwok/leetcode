package medium

import helper.TreeNode
import java.util.*

class Q114FlattenBinaryTreetoLinkedList {
    fun flatten(root: TreeNode?): Unit {
        if(root == null) {
            return;
        } else {
            val lst = LinkedList<TreeNode>();
            traverse(root, lst);
            for(i in 0..lst.size - 2) {
                val node = lst[i];
                node.left = null;
                node.right = lst[i + 1]
            }
            return;
        }
    }

    fun traverse(node: TreeNode, lst: LinkedList<TreeNode>) {
        lst.add(node);

        if(node.left !=null) {
            traverse(node.left, lst)
        }
        if(node.right !=null) {
            traverse(node.right, lst);
        }
    }
}