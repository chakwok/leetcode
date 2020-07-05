package challenge.april

class D25 {
    fun canJump(nums: IntArray): Boolean {
        if(nums.size <= 1) {
            return true;
        }

        var idx = 0;
        var maxDest = nums[0];
        while(maxDest != idx) {
            var nextMaxDest = idx;

            for(i in idx..maxDest) {
                val curr = i + nums[i];
                nextMaxDest = maxOf(curr, nextMaxDest);

                if(nextMaxDest >= nums.size - 1) {
                    return true;
                }
            }

            idx = maxDest;
            maxDest = nextMaxDest;
        }

        return false;
    }

}