package medium

// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

class PeekingIterator(iterator:Iterator<Int>):Iterator<Int> {
    private var peeked: Int? = null
    val iterator = iterator;
    fun peek(): Int {
        if(peeked == null) {
            peeked = iterator.next();
        }

        return peeked!!
    }

    override fun next(): Int {
        peeked?.let {
            peeked = null
            return it
        }
        return iterator.next()

    }

    override fun hasNext(): Boolean {
        if(peeked != null) {
            return true
        } else {
            return iterator.hasNext()
        }
    }
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */