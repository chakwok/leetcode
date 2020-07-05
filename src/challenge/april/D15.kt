package challenge.april

class D15 {

    fun productExceptSelf(nums: IntArray): IntArray {
        val roaming = IntArray(nums.size);
        roaming[0] = 1;
        for(i in 1 until roaming.size) {
            roaming[i] = roaming[i-1] * nums[i-1];
        }

        val out = roaming;
        var temp  = 1;
        for(i in (out.size - 2) downTo 0) {
            temp *= nums[i+1]
            out[i] *= temp;
        }

        return out;
    }

    //O(n) space
    fun productExceptSelfOld(nums: IntArray): IntArray {
        //roam right
        val rRoam = IntArray(nums.size);
        rRoam[0] = 1;
        for(i in 1 until rRoam.size) {
            rRoam[i] = rRoam[i-1] * nums[i-1];
        }
        
        //roam left
        val lRoam = IntArray(nums.size);
        lRoam[lRoam.size - 1] = 1
        for(i in (lRoam.size - 2) downTo 0) {
            lRoam[i] = lRoam[i+1] * nums[i+1];
        }


        val out = IntArray(nums.size);
        for(i in out.indices) {
            out[i] = lRoam[i] * rRoam[i];
        }
        return out;
    }
}