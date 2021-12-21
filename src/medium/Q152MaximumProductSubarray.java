package medium;

public class Q152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int head = 0;

        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(curr == 0) {
                max = Math.max(max, 0);
                max = Math.max(max, maxProductNonZero(nums, head, i - 1));

                head = i+1;
            }
        }

        if(head < nums.length) {
            max = Math.max(max, maxProductNonZero(nums, head, nums.length - 1));
        }

        return max;
    }


    public int maxProductNonZero(int[] nums, int from , int to) {
        if(from >= to) {
            return nums[from];
        }

        int sumProduct = 1;
        for(int i = from; i <= to; i++) {
            sumProduct *= nums[i];
        }

        if(sumProduct > 0) {
            return sumProduct;
        }

        int slidingSumHead = sumProduct;
        for(int i = from; i <= to; i++) {
            slidingSumHead /= nums[i];
            if(nums[i] < 0) {
                break;
            }
        }

        int slidingSumTail = sumProduct;
        for(int i = to; i >= from; i--) {
            slidingSumTail /= nums[i];
            if(nums[i] < 0) {
                break;
            }
        }

        return Math.max(slidingSumHead, slidingSumTail);
    }
}
