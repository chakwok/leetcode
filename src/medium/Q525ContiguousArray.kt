package medium


class Q525ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {
        val map: MutableMap<Int, Int> = HashMap()
        map[0] = -1
        var maxlen = 0
        var count = 0
        for (i in nums.indices) {
            count = count + if (nums[i] == 1) 1 else -1
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map[count]!!)
            } else {
                map[count] = i
            }
        }
        return maxlen
    }
}