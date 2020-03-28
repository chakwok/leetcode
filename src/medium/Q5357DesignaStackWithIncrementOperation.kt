package medium

import medium.Q5357DesignaStackWithIncrementOperation.CustomStack




class Q5357DesignaStackWithIncrementOperation {
    class CustomStack(maxSize: Int) {
        var stackMaxSize = maxSize;
        var lst = arrayListOf<Int>();

        fun push(x: Int) {
            if(lst.size < stackMaxSize) {
                lst.add(x);
            }
        }

        fun pop(): Int {
            if(lst.size > 0) {
                return lst.removeAt(lst.size - 1)
            }
            return -1;
        }

        fun increment(k: Int, `val`: Int) {
            if(k >= lst.size) {
                for(i in lst.indices) {
                    lst[i] += `val`
                }
            } else {
                for(i in 0 until k) {
                    lst[i] += `val`
                }
            }
        }
    }
}

fun main() {
    val customStack = CustomStack(3) // Stack is Empty []

    customStack.push(1) // stack becomes [1]

    customStack.push(2) // stack becomes [1, 2]

    customStack.pop() // return 2 --> Return top of the stack 2, stack becomes [1]

    customStack.push(2) // stack becomes [1, 2]

    customStack.push(3) // stack becomes [1, 2, 3]

    customStack.push(4) // stack still [1, 2, 3], Don't add another elements as size is 4

    customStack.increment(5, 100) // stack becomes [101, 102, 103]

    customStack.increment(2, 100) // stack becomes [201, 202, 103]

    customStack.pop() // return 103 --> Return top of the stack 103, stack becomes [201, 202]

    customStack.pop() // return 202 --> Return top of the stack 102, stack becomes [201]

    customStack.pop() // return 201 --> Return top of the stack 101, stack becomes []

    customStack.pop() // return -1 --> Stack is empty return -1.

}