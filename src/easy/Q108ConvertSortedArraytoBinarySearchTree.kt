package easy

import helper.TreeNode

fun main() {
    sortedArrayToBST(intArrayOf(-10,-3,0,5,9))
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return inOrderHelper(nums, 0, nums.size - 1)
}

private fun inOrderHelper(nums: IntArray, lo: Int, hi: Int): TreeNode? {
    if(lo > hi) {
        return null
    }
    val mi = lo + (hi - lo)/ 2

    val node = TreeNode(nums[mi])
    node.left = inOrderHelper(nums, lo, mi - 1)
    node.right = inOrderHelper(nums, mi + 1, hi)

    return node
}