package hard;

public class Q239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 ||k == 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for(int j = i + 1; j < i + k ; j++) {
                if(nums[j] > max) {
                    max = nums[j];
                }
            }

            result[i] = max;
        }

        return result;
    }
}
