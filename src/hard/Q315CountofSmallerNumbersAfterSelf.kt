package hard

import java.util.*
import java.util.concurrent.ConcurrentSkipListSet
import kotlin.collections.ArrayList

fun main() {
    countSmaller(intArrayOf(5,2,6,1)).joinToString().also {println(it)}
    countSmaller(intArrayOf(-1)).joinToString().also {println(it)}
    countSmaller(intArrayOf(-1,-1)).joinToString().also {println(it)}
    val input = intArrayOf(26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41)
    countSmaller(input).joinToString().also {println(it)}
}

// average case: (nlogn). worst case: (n^2). passed 63/65 test cases
fun countSmaller(nums: IntArray): List<Int> {
    val ans = LinkedList<Int>()

    val lst = ConcurrentSkipListSet<Pair<Int, Int>>(
        compareBy<Pair<Int, Int>> {it.first}.then(compareBy { it.second })
    )

    for(i in nums.size - 1 downTo 0) {
        val entry = Pair(nums[i], i)
        lst.add(entry)
        ans.addFirst(lst.indexOf(entry))
    }

    return ans
}


// despite the O(logn) binary search, the linkedList.add(idx, element) takes O(n).
// the solution is still O (n^2), only as good as Brute Force.
// this solution needs a O(logn) add, and insertion Collection
fun countSmallerOld(nums: IntArray): List<Int> {
    val ans = ArrayList<Int>(nums.size);

    val roamingSortedList = ArrayList<Int>();

    for(i  in nums.size - 1 downTo 0) {
        val first = addToSortedList(nums[i], roamingSortedList);
        ans.add(first);
    }

    return ans.reversed();
}

private fun <T: Comparable<T>> addToSortedList(element: T, list: MutableList<T>): Int {
    val result = list.binarySearch(element);
    var idx = if(result >= 0) result else -(result + 1);
    list.add(idx, element);
    while(idx > 0 && list[idx - 1] == list[idx]) {
        idx--;
    }
    return idx;
}

/*
private fun <T: Comparable<T>> firstIndexOfSortedList(element: T, list: List<T>): Int {
    var idx = list.binarySearch(element);
    while(idx > 0 && list[idx - 1] == list[idx]) {
        idx--;
    }
    return idx
}*/
