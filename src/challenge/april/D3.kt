package challenge.april

class D3 {
    // n
    fun maxSubArray(nums: IntArray): Int {
        var currBest = 0;
        var currSum = 0;
        for(num in nums) {
            currSum = maxOf(0, currSum + num);
            currBest = maxOf(currSum, currBest);
        }
        if(currBest == 0) {
            currBest = nums.max()?: return 0
        }

        return currBest;
    }

    //nlogn
    fun maxSubArrayOld(nums: IntArray): Int {
        return maxSubArray(nums, 0, nums.size - 1);
    }

    fun maxSubArray(nums: IntArray, lo: Int, hi: Int): Int {
        if(hi == lo) {
            return nums[lo]
        } else {
            val mi = lo + ((hi - lo) / 2);
            var currSum = nums[mi];

            var maxLeft = 0;
            var lSum = 0;
            if(mi > lo) {
                for(i in mi - 1 downTo lo) {
                    lSum += nums[i];
                    maxLeft = maxOf(lSum, maxLeft);
                }
            }

            var rSum = 0;
            var maxRight = 0;
            for(i in mi + 1..hi) {
                rSum += nums[i];
                maxRight = maxOf(rSum, maxRight);
            }

            currSum += (if(maxLeft > 0) maxLeft else 0) + (if(maxRight > 0) maxRight else 0);
            return maxOf(maxSubArray(nums, lo, mi), maxSubArray(nums, mi + 1, hi), currSum)
        }
    }
}

fun main() {
    println(D3().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(D3().maxSubArray(intArrayOf(-1)))
}