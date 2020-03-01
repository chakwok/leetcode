package easy

fun main() {
    val res = smallerNumbersThanCurrent(intArrayOf(6,5,4,8))
    println(res.joinToString())
    println(smallerNumbersThanCurrent(intArrayOf(7,7,7,7)).joinToString())
}

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val counts = IntArray(101) {0};
    for (num in nums) {
        counts[num]++;
    }

    val aggCounts = IntArray(101) {0};
    for(i in 1 until counts.size) {
        aggCounts[i] = aggCounts[i - 1] + counts[i - 1];
    }

    val res = IntArray(nums.size);
    for(i in res.indices) {
        res[i] = aggCounts[nums[i]];
    }
    return res;
}
