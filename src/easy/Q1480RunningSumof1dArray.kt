package easy

fun runningSum(nums: IntArray): IntArray {
    if(nums.size <= 1) {
        return nums;
    }

    for(i in 1 until nums.size) {
        nums[i] = nums[i] + nums[i-1]
    }
    return nums;
}