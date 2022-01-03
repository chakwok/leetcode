package medium;

public class Q213HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        } else if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else return Math.max(robOriginal(nums, 0, nums.length - 2), robOriginal(nums, 1, nums.length - 1));
    }

    public int robOriginal(int[] nums, int i, int j) {
        int diff = j - i;
        if(diff == 0) {
            return nums[i];
        } else if(diff == 1) {
            return Math.max(nums[i], nums[j]);
        }

        int[] dp = new int[nums.length];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i], nums[i+1]);

        for(int k = i + 2; k <= j; k++) {
            dp[k] = Math.max(nums[k] + dp[k-2], dp[k-1]);
        }

        return dp[j];
    }

    public static void main(String[] args) {
        Q213HouseRobberII app = new Q213HouseRobberII() ;
        System.out.println(app.rob(new int[] {2,3,2}));
        System.out.println(app.rob(new int[] {1,2,3,1}));
        System.out.println(app.rob(new int[] {1,2,3}));

    }
}
