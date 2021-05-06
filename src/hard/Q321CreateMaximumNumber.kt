package hard

fun main() {
//    println(maxOf(listOf(), listOf(6,5,7,6,2)))
//    println("" > "44")
    maxNumber(intArrayOf(6,6,8), intArrayOf(5,0,9), 3).also {println(it.joinToString())}
    maxNumber(intArrayOf(3,4,6,5), intArrayOf(9,1,2,5,8,3), 5).also {println(it.joinToString())}
    maxNumber(intArrayOf(6,7), intArrayOf(6,0,4), 5).also {println(it.joinToString())}
    maxNumber(intArrayOf(3,9), intArrayOf(8,9), 3).also {println(it.joinToString())}
    maxNumber(intArrayOf(2,5,6,4,4,0), intArrayOf(7,3,8,0,6,5,7,6,2), 15).also {println(it.joinToString())}
    //[7,3,8,2,5,6,4,4,0,8,6,5,7,6,2]
    //[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0] expected
    maxNumber(intArrayOf(2,1,7,8,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5), intArrayOf(2,6,2,0,1,0,5,4,5,5,3,3,3,4), 35).also {println(it.joinToString())}
/*
* Output:
[2,6,2,2,1,7,8,0,1,0,5,4,5,5,3,3,3,4,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5]
Expected:
[2,6,2,2,1,7,8,0,1,7,3,5,8,9,0,1,0,5,4,5,5,3,3,3,4,0,0,7,0,2,2,7,3,5,5]*/
}
//maxNumber "", maxNumber "65762"


fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
   return maxNumber(nums1, nums2, k, 0, 0).toIntArray()
}
//Input: nums1 = [3,9], nums2 = [8,9], k = 3
//Time exceeds limit
fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int, idx1: Int, idx2: Int): List<Int> {
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
//            val computed1 = LinkedList(computed).also { it.add(max1) }
            val maxNumber1 = maxNumber(nums1, nums2, k - out.size, maxPos1 + 1, currIdx2)

            // choosing maxPos2
//            val computed2 = LinkedList(computed).also { it.add(max2) }
            val maxNumber2 = maxNumber(nums1, nums2, k - out.size, currIdx1, maxPos2 + 1)

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