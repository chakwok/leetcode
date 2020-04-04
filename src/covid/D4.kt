package covid

class D4 {
    fun moveZeroes(nums: IntArray): Unit {
        var idx = 0
        var possibleNonZero = 0;
        outer@ while(idx < nums.size) {
            if(nums[idx] == 0) {
                for(i in maxOf(possibleNonZero, idx + 1) until nums.size) {
                    if(nums[i] != 0) {
                        nums[idx] = nums[i]
                        nums[i] = 0
                        /*val temp = nums[idx];
                        nums[idx] = nums[i];
                        nums[i] = temp;*/
                        possibleNonZero = i + 1;
                        break;
                    }
                    if(i == nums.size - 1) {
                        break@outer;
                    }
                }
            }

            idx++;
        }

        return;
    }
}

fun main() {
    val arr = intArrayOf(0, 0, 1 )
    D4().moveZeroes(intArrayOf(0, 0, 1 ))
    println(arr.joinToString(", "))
}
