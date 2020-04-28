package covid

import java.util.*
import java.util.concurrent.ConcurrentSkipListSet
import kotlin.NoSuchElementException

class D2x {
    class FirstUnique(nums: IntArray) {
        val set = hashSetOf<Int>();
        val skipListSet = LinkedHashSet<Int>();
        init {
            for(num in nums) {
                add(num);
            }
        }


        fun showFirstUnique(): Int {
            return try {skipListSet.first()} catch(ex:NoSuchElementException) { -1 }
        }

        fun add(value: Int) {
            if(set.contains(value)) {
                return;
            } else {
                if(skipListSet.contains(value)) {
                    skipListSet.remove(value);
                    set.add(value);
                } else {
                    skipListSet.add(value);
                }
            }
        }

    }
}

fun main() {
    val cls = D2x.FirstUnique(intArrayOf(233))
    println(cls.showFirstUnique())
    cls.add(5)
    println(cls.showFirstUnique())
}