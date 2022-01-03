package medium;

import java.util.HashMap;
import java.util.Map;

public class Q198HouseRobber {
    //[1,2,3,1] -> 4
    //[2,7,9,3,1] -> 12
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        } else if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[dp.length - 1];
    }
}
