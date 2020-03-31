package medium

import java.util.*

class Q341FlattenNestedListIterator {
    class NestedIterator(nestedList: List<NestedInteger>) {
        val stack = LinkedList<NestedInteger>()
        var curr: NestedInteger?;
        var head: Int?
        init {
            if(nestedList.size > 0) {
                curr = nestedList[0]
            } else {
                curr = null;
            }
        }

        fun next(): Int {

        }

        fun hasNext(): Boolean {
            if(curr)
        }
    }
}

class NestedInteger {
/*    *     // Constructor initializes an empty nested list.
    *     constructor()
    *
    *     // Constructor initializes a single integer.
    *     constructor(value: Int)
    *
    *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
    *     fun isInteger(): Boolean
    *
    *     // @return the single integer that this NestedInteger holds, if it holds a single integer
    *     // Return null if this NestedInteger holds a nested list
    *     fun getInteger(): Int?
    *
    *     // Set this NestedInteger to hold a single integer.
    *     fun setInteger(value: Int): Unit
    *
    *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    *     fun add(ni: NestedInteger): Unit
    *
    *     // @return the nested list that this NestedInteger holds, if it holds a nested list
    *     // Return null if this NestedInteger holds a single integer
    *     fun getList(): List<NestedInteger>?*/
}