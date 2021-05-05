package medium

fun main() {
    jump(intArrayOf(2,3,1,1,4)).also {println(it)}
    jump(intArrayOf(2,1)).also {println(it)}
//    jump(intArrayOf(2,3,1,1,4)).also {println(it)/**/}
}

fun jump(nums: IntArray): Int {
    if(nums.size <= 1) {
        return 0
    }

    var jumped = 0
    var maxReach = nums[0]

    var curr = 0
    while(curr < (nums.size - 1)) {
        if(maxReach >= nums.size - 1) {
            //jump to the end
            jumped++
            break
        }

        for(i in curr..maxReach) {
            val reachable = i + nums[i]
            if(reachable > maxReach) {
                curr = i
                maxReach = reachable
            }
        }
        jumped++
    }

    return jumped
}