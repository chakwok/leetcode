package challenge.april

class D1 {
    fun singleNumber(nums: IntArray): Int {
        var acc = 0;
        for(num in nums) {
            acc = acc xor num;
        }
        return acc;
    }
}

fun main() {
}