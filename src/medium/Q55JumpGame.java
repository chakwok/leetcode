package medium;

public class Q55JumpGame {
    public boolean canJump(int[] nums) {
        int maxIndex = nums.length - 1;
        int maxJump = 0;

        for (int i = 0; i < nums.length; i ++) {
            maxJump = Math.max(maxJump - 1, nums[i]);
            if (i + maxJump >= maxIndex) {
                return true;
            }

            //can't go any further than this pos; There is nothing chance reaching further.
            if (maxJump <= 0) {
                return false;
            }
        }

        return false;
    }
/*    boolean[] cantReachEnd;
    public boolean canJump(int[] nums) {
        cantReachEnd = new boolean[nums.length];

        *//*for (int i = nums.length - 1; i > 0; i--) {
            if (isReachable(nums, i, nums.length - 1)) {
                return true;
            }
        }*//*

        return isReachable(nums, nums.length - 1);
    }

    public boolean isReachable(int[] nums, int target) {
        if (target == 0) {
            return true;
        }

        for (int i = target -1; i > 0; i++) {
            if (i + nums[i] >= target) {
                return true;
            }
        }

        return false;


    }

    public boolean isReachable(int[] nums, int pos, int target) {
        if (target == 0) {
            return true;
        }
        return false;
    }*/



}
