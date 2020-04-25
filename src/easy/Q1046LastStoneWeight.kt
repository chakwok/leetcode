package easy

import java.util.*

class Q1046LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val q = PriorityQueue<Int>() { a, b -> b - a }
        for(s in stones) {
            q.add(s)
        }
        while(q.isEmpty().not()) {
            val f = q.poll()
            if(q.isEmpty()) return f
            val s = q.poll()
            if(s == f) continue
            q.add(Math.max(f, s) - Math.min(f,s))
        }
        return 0
    }
}