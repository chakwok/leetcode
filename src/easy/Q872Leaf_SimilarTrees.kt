package easy

import helper.TreeNode

class Q872Leaf_SimilarTrees {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        }

        val ls1 = getLeafSequence(root1);
        val ls2 = getLeafSequence(root2);

        if(ls1.size != ls2.size) {
            return false;
        } else {
            for(i in ls1.indices) {
                if(ls1[i].`val` != ls2[i].`val`) {
                    return false;
                }
            }
            return true;
        }
    }

    private fun getLeafSequence(root: TreeNode): List<TreeNode> {
        val lst = arrayListOf<TreeNode>();
        getLeafSequence(root, lst);
        return lst;
    }

    private fun getLeafSequence(root: TreeNode, lst: MutableList<TreeNode>) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            lst.add(root);
            return;
        }

        if(root.left != null) {
            getLeafSequence(root.left, lst);
        }
        if(root.right != null) {
            getLeafSequence(root.right, lst);
        }
    }


}