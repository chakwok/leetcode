package medium

import java.util.concurrent.ConcurrentSkipListSet

class Q1049LastStoneWeightII {
    fun lastStoneWeightII(stones: IntArray): Int {
        val sortedSet = ConcurrentSkipListSet<Int>();
        stones.sort();

        run {
            var i = 0;
            while(i < stones.size) {
                if(i == stones.size - 1) {
                    sortedSet.add(stones[i])
                } else if(stones[i] == stones[i+1]) {
                    i += 2;
                    continue;
                }
                sortedSet.add(stones[i])
                i++;
            }
        }

        while(sortedSet.size > 1) {
            val iter = sortedSet.iterator()
            var prev = iter.next();

            var minDiff = Int.MAX_VALUE;
            var smaller = prev;
            while(iter.hasNext()) {
                val curr = iter.next();
                val diff = curr - prev;
                if(diff < minDiff) {
                    minDiff = diff;
                    smaller = prev;
                }

                prev = curr;
            }

            sortedSet.remove(smaller);
            sortedSet.remove(smaller + minDiff);
            if(sortedSet.contains(minDiff)) {
                sortedSet.remove(minDiff);
            } else {
                sortedSet.add(minDiff);
            }
        }

        return if(sortedSet.size == 1) sortedSet.first() else 0;
    }
}

fun main() {
    Q1049LastStoneWeightII().lastStoneWeightII(intArrayOf(2,7,4,1,8,1))
}