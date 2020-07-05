package challenge.april

import java.util.*

class D12 {
    //nlogn
    fun lastStoneWeight(stones: IntArray): Int {
        val maxPq: Queue<Int> = PriorityQueue(stones.size, reverseOrder<Int>())
        for (stone in stones) {
            maxPq.add(stone)
        }

        while (maxPq.size >= 2) {
            val y = maxPq.poll()
            val x = maxPq.poll()
            if (y > x) {
                maxPq.add(y - x)
            }
        }
        return if (maxPq.isEmpty()) 0 else maxPq.peek()
    }
    //n^2
    fun lastStoneWeightOld(stones: IntArray): Int {
        val lst = stones.toMutableList();

        var fi = -1;
        var se = -1;
        while (lst.size > 1) {
            for(i in lst.indices) {
                val fiVal = if(fi == -1) Int.MIN_VALUE else lst[fi];
                val seVal = if(se == -1) Int.MIN_VALUE else lst[se];
                if(lst[i] >= fiVal) {
                    se = fi;
                    fi = i;
                } else if(lst[i] > seVal) {
                    se = i;
                }
            }

            if(lst[fi] == lst[se]) {
                lst.removeAt(fi);
                lst.removeAt(se);
            } else {
                lst[fi] = lst[fi] - lst[se];
                lst.removeAt(se);
            }

            fi = -1;
            se = -1;
        }

        return if(lst.size > 0) lst[0] else 0;
    }
}

fun main() {
    println(D12().lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}