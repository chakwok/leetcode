package easy;

public class Q485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxCount = 0;

        int currMax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currMax++;
                maxCount = Math.max(maxCount, currMax);
            } else if(nums[i] == 0){
                currMax = 0;
            }
        }
        return maxCount;
    }
}
