package medium

import java.util.*

class Q341FlattenNestedListIterator {
    class NestedIterator(nestedList: List<NestedInteger>) {
        private val stackToIdx = LinkedList<Pair<List<NestedInteger>, Int>>()

        var next: Int?= null;
        var idx = 0;
        var lst: List<NestedInteger> = nestedList;

        init {
            updateNext()
        }

        private fun updateNext() {
            if(idx < lst.size) {
                val curr = lst[idx];
                if(curr.isInteger()) {
                    next = curr.getInteger();
                    idx++;
                    return;
                } else {
                    stackToIdx.push(Pair(lst, ++idx));
                    lst = curr.getList()!!;
                    idx = 0;
                    updateNext();
                }
            } else if(stackToIdx.size > 0) {
                val pair = stackToIdx.pop()
                lst = pair.first
                idx = pair.second
                updateNext();
            } else {
                return;
            }
        }

        fun next(): Int {
            val res =  next!!;
            next = null;
            updateNext();
            return res;
        }

        fun hasNext(): Boolean {
            return next != null;
        }
    }
}

interface NestedInteger {
          // Constructor initializes an empty nested list.
//          constructor()
     
          // Constructor initializes a single integer.
//          constructor(value: Int)
     
          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          fun isInteger(): Boolean
     
          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          fun getInteger(): Int?
     
          // Set this NestedInteger to hold a single integer.
          fun setInteger(value: Int): Unit
     
          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          fun add(ni: NestedInteger): Unit
     
          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          fun getList(): List<NestedInteger>?
}