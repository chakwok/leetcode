package medium;

import java.util.Arrays;

public class Q300LongestIncreasingSubsequence {
    //An elegant O(nlogn) dp solutions
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    //runtime: O(n^2)
    //space: O(n)
    public static int lengthOfLIS2(int[] nums) {
        if(nums == null) {
            return 0;
        } else if(nums.length <= 1) {
            return nums.length;
        }

        int[] maxJump = new int[nums.length];
        int maxTotal = 1;
        maxJump[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            int currentMax = 1;
            for(int j = i; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    currentMax = Math.max(currentMax, 1 + maxJump[j]);
                }
            }
            maxJump[i] = currentMax;
            if (currentMax > maxTotal) {
                maxTotal = currentMax;
            }
        }
        return maxTotal;
    }

    public static void main(String[] args) {
        int ans = lengthOfLIS(new int[]{-2, -1});
        System.out.println(ans);
    }
}
