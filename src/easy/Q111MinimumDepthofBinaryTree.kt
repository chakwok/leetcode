package easy

import helper.TreeNode

fun minDepth(root: TreeNode?): Int {
    return if(root == null) {
        0
    } else preOrderHelper(root, 0, Int.MAX_VALUE)
}

fun preOrderHelper(node: TreeNode, depth: Int, minDepth: Int): Int {
    if(node.left == null && node.right == null) {
        return depth + 1
    }

    val minLeft = if(node.left != null) preOrderHelper(node.left, depth + 1, minDepth) else minDepth
    val minRight = if(node.right != null) preOrderHelper(node.right , depth + 1, minDepth) else minDepth

    return minOf(minLeft, minRight)
}