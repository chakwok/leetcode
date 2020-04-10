package covid

class D10 {
    class MinStack() {

        /** initialize your data structure here. */
        internal val lst = ArrayList<Node>();

        fun push(x: Int) {
            val currMin = if(lst.size == 0) x else minOf(x, getMin());
            lst.add(Node(x, currMin))
        }

        fun pop() {
            lst.removeAt(lst.size - 1);
        }

        fun top(): Int {
            return lst[lst.size - 1].item;
        }

        fun getMin(): Int {
            return lst[lst.size - 1].min;
        }

        class Node(
                val item: Int,
                val min: Int,
                var next: Node? = null
        ) {

        }
    }


    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(x)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */
}

fun main() {
    val minStack = D10.MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();
    minStack.pop();
    minStack.top();
    minStack.getMin();
}