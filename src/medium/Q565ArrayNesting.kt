package medium

fun arrayNesting(nums: IntArray): Int {
    val used = BooleanArray(nums.size) { false }

    var max = Int.MIN_VALUE;
    val set = mutableSetOf<Int>();
    for(i in used.indices) {
        if(used[i]) {
            continue;
        }

        var curr = nums[i]
        while(!set.contains(curr)) {
            set.add(curr);

            used[curr] = true
            curr = nums[curr]
        }
        max = maxOf(max, set.size)
        set.clear()
    }

    return max;
}