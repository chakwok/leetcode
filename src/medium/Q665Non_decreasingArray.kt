package medium

fun main() {
    println(checkPossibility(intArrayOf(4,2,1)))
    println(checkPossibility(intArrayOf(4,2,3)))
    println(checkPossibility(intArrayOf(5,4,4,6,7)))
    println(checkPossibility(intArrayOf(10,10,9,12,13)))
}

fun checkPossibility(nums: IntArray): Boolean {
    return checkPossibilityChangeCurr(nums) || checkPossibilityChangePrev(nums)
}

fun checkPossibilityChangeCurr(nums: IntArray): Boolean {
    if(nums.size <= 1) {
        return true
    }

    var modified = 0
    var prev = Int.MIN_VALUE

    for(i in nums) {
        if(i < prev) {
            if(++modified > 1) {
                return false
            }
            // current position's value is changed to previous one. so no update needs to be done
        } else {
            prev = i
        }
    }

    return true;
}

fun checkPossibilityChangePrev(nums: IntArray): Boolean {
    if(nums.size <= 1) {
        return true
    }

    var modified = 0
    var prev = Int.MIN_VALUE
    var secondPrev = Int.MIN_VALUE

    for(i in nums) {
        if(i < prev) {
            if(++modified > 1) {
                return false
            }

            if(secondPrev > i) {
                return false
            }
            prev = i
        } else {
            secondPrev = prev
            prev = i
        }
    }

    return true;
}