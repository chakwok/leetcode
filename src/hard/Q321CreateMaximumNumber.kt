package hard

import java.util.*
//ref https://web.archive.org/web/20160120093629/http://algobox.org/create-maximum-number/


fun main2() {
//    println(maxOf(listOf(), listOf(6,5,7,6,2)))
//    println("" > "44")
    maxNumberBF(intArrayOf(6,6,8), intArrayOf(5,0,9), 3).also {println(it.joinToString())}
    maxNumber(intArrayOf(3,4,6,5), intArrayOf(9,1,2,5,8,3), 5).also {println(it.joinToString())}
    maxNumber(intArrayOf(6,7), intArrayOf(6,0,4), 5).also {println(it.joinToString())}
    maxNumber(intArrayOf(3,9), intArrayOf(8,9), 3).also {println(it.joinToString())}
    maxNumber(intArrayOf(2,5,6,4,4,0), intArrayOf(7,3,8,0,6,5,7,6,2), 15).also {println(it.joinToString())}
    //[7,3,8,2,5,6,4,4,0,8,6,5,7,6,2]
    //[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0] expected
    maxNumber(intArrayOf(2,1,7,8,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5), intArrayOf(2,6,2,0,1,0,5,4,5,5,3,3,3,4), 35)
        .also {println(it.joinToString())}



/*
* Output:
[2,6,2,2,1,7,8,0,1,0,5,4,5,5,3,3,3,4,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5]
Expected:
[2,6,2,2,1,7,8,0,1,7,3,5,8,9,0,1,0,5,4,5,5,3,3,3,4,0,0,7,0,2,2,7,3,5,5]*/
}
//maxNumber "", maxNumber "65762"


fun maxNumberBF(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
   return maxNumberBF(nums1, nums2, k, 0, 0).toIntArray()
}
//Input: nums1 = [3,9], nums2 = [8,9], k = 3
//Time exceeds limit

fun maxNumberBF(nums1: IntArray, nums2: IntArray, k: Int, idx1: Int, idx2: Int): List<Int> {
    val out = mutableListOf<Int>()

    var currIdx1 = idx1
    var currIdx2 = idx2

    while(out.size < k) {
        val elementLeft1 = nums1.size - currIdx1
        val elementLeft2 = nums2.size - currIdx2

        val elementNeeded = k - out.size
        val maxSkip = elementLeft1 + elementLeft2 - elementNeeded // 1

        var max1 = Int.MIN_VALUE
        var maxPos1 = -1
        for(i in currIdx1 .. minOf(nums1.size - 1, (currIdx1 + maxSkip))) {
            val curr = nums1[i]
            if(curr > max1) {
                max1 = curr
                maxPos1 = i
            }
        }

        var max2 = Int.MIN_VALUE
        var maxPos2 = -1
        for(i in currIdx2 .. minOf(nums2.size - 1, (currIdx2 + maxSkip))) {
            val curr = nums2[i]
            if(curr > max2) {
                max2 = curr
                maxPos2 = i
            }
        }

        if(max1 > max2) {
            out.add(max1)
            currIdx1 = maxPos1 + 1
        } else if(max2 > max1) {
            out.add(max2)
            currIdx2 = maxPos2 + 1
        } else {
            out.add(max1) //max1 == max2

            //choosing maxPos1
            val maxNumber1 = maxNumberBF(nums1, nums2, k - out.size, maxPos1 + 1, currIdx2)

            // choosing maxPos2
            val maxNumber2 = maxNumberBF(nums1, nums2, k - out.size, currIdx1, maxPos2 + 1)

            return out + maxOf(maxNumber1, maxNumber2)
        }
    }

    return out
}

    /*fun <T: Comparable<T>> maxOf(list1: List<T>,  list2: List<T>): List<T> {
        //can improve, but doesn't affect runtime O(n) anyways
        val joint1 = list1.joinToString("")
        val joint2 = list2.joinToString("")
        return when {
            joint1 >= joint2 -> list1
            else -> list2
        }
    }*/

fun <T: Comparable<T>> maxOf(list1: List<T>,  list2: List<T>): List<T> {
    var pos = 0
    while(pos < list1.size && pos < list2.size) {
        if(pos >= list1.size) {
            return list2
        } else if(pos >= list2.size) {
            return list1
        }
        val diff = list1[pos].compareTo(list2[pos])
        when {
            diff >0 -> return list1
            diff <0 -> return list2
            else -> pos++
        }
    }

    return list1
}


/*
Initialize a empty stack
Loop through the array nums
pop the top of stack if it is smaller than nums[i] until
1. stack is empty
2. the digits left is not enough to fill the stack to size k
if stack size < k push nums[i]
Return stack
*/
//O(n)
private fun maxArrayStack(nums: IntArray, len: Int): IntArray {
    val stack = Stack<Int>()
    for (i in nums.indices) {
        while (!stack.empty() && stack.peek() < nums[i] && stack.size + nums.size - i > len) {
            stack.pop()
        }
        if (stack.size < len) {
            stack.push(nums[i])
        }
    }
    val result = IntArray(len)
    for (i in len - 1 downTo 0) {
        result[i] = stack.pop()
    }
    return result
}

// this avoids the use of stack
fun maxArray(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val ans = IntArray(k)
    var i = 0
    var j = 0
    while (i < n) {
        while (j > 0 && ans[j - 1] < nums[i] && n - i + j > k) j--
        if (j < k) ans[j++] = nums[i]
        ++i
    }
    return ans
}

//merge the two array to one
//select the largest maxNumber from the one array
fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
    val merged = mergeArray(nums1, nums2)

    return maxArray(merged, k)
}

private fun mergeArray(nums1: IntArray, nums2: IntArray): IntArray {
//    return mergeArray(nums1, 0, nums2, 0)
    val out = IntArray(nums1.size + nums2.size)
    var fill = 0

    var idx1 = 0
    var idx2 = 0

    while(fill < out.size) {
        if(compareToElement(nums1, idx1, nums2, idx2) >= 0) {
            out[fill++] = nums1[idx1++]
        } else {
            out[fill++] = nums1[idx2++]
        }
    }

    return out
}

private fun compareToElement(nums1: IntArray, idx1: Int, nums2: IntArray, idx2: Int): Int {
    if(idx2 >= nums2.size) {
        return Int.MAX_VALUE
    } else if(idx1 >= nums1.size) {
        return Int.MIN_VALUE
    }

    val diff = nums1[idx1].compareTo(nums2[idx2])
    if(diff != 0) {
        return diff
    } else {
        return compareToElement(nums1, idx1 + 1, nums2, idx2 + 1)
    }
}