package easy

class Q1313DecompressRun_LengthEncodedList {
    fun decompressRLElist(nums: IntArray): IntArray {
        val res = arrayListOf<Int>();
        for(i in nums.indices step 2 ) {
            for(j in 0 until nums[i]) {
                res.add(nums[i+1]);
            }
        }
        return res.toIntArray();
    }
}

fun main() {
    Q1313DecompressRun_LengthEncodedList().decompressRLElist(intArrayOf(1,2,3,4))
}