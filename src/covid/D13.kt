package covid

import java.util.*


class D13 {
    fun findMaxLength(nums: IntArray): Int {
        val arr = IntArray(2 * nums.size + 1)
        Arrays.fill(arr, -2)
        arr[nums.size] = -1
        var maxlen = 0
        var count = 0
        for (i in nums.indices) {
            count += if (nums[i] == 0) -1 else 1
            if (arr[count + nums.size] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.size])
            } else {
                arr[count + nums.size] = i
            }
        }
        return maxlen
    }

    fun findMaxLengthFail(nums: IntArray): Int {
        val maxContiguous = BooleanArray(nums.size);

        markContiguous(nums, 0, nums.size - 1, maxContiguous);
        return findMaxLength(maxContiguous);
    }

    fun markContiguous(nums: IntArray, lo: Int, hi: Int, maxContiguous: BooleanArray) {
        if(hi == lo) {
            return;
        }

        val mi = lo + (hi - lo) / 2;
        var countZero = 0;
        var countOne = 0;
        for(i in lo..hi) {
            if(nums[i] == 0) {
                countZero++
            } else {
                countOne++
            }
        }

        if(countOne == countZero) {
            for(i in lo..hi) {
                maxContiguous[i] = true;
            }
        }

        if(lo == mi) {
            return;
        }

        markContiguous(nums, lo, mi, maxContiguous);
        markContiguous(nums, if((hi-mi)%2 == 0) mi+1 else mi , hi, maxContiguous);
    }

    fun findMaxLength(arr: BooleanArray): Int {
        var max = 0;
        var curr = 0;

        for(i in arr) {
            if(i) {
                curr++;
                max = maxOf(curr, max);
            } else {
                curr = 0;
            }
        }

        return if(max%2 == 1) max - 1 else max;
    }
}

fun main() {
    println(D13().findMaxLength(intArrayOf(0, 1)))
    println(D13().findMaxLength(intArrayOf(0, 1, 0)))
}