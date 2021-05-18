package medium

import helper.ListNode
import helper.TreeNode

private var node: ListNode? = null

fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) {
        return null
    }
    var size = 0
    var runner = head
    node = head
    while (runner != null) {
        runner = runner.next
        size++
    }
    return inorderHelper(0, size - 1)
}

fun inorderHelper(start: Int, end: Int): TreeNode? {
    if (start > end) {
        return null
    }
    val mid = start + (end - start) / 2
    val left = inorderHelper(start, mid - 1)
    val treenode = TreeNode(node!!.`val`)
    treenode.left = left
    node = node!!.next
    val right = inorderHelper(mid + 1, end)
    treenode.right = right
    return treenode
}