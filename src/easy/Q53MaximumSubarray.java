package easy;

public class Q53MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    //runtime: O(nlgn)
    public static int maxSubArray(int[] nums, int lo, int hi) {
        if (hi == lo) {
            return nums[lo];
        }

        int mi = lo + (hi - lo) / 2;

        int maxLeft = maxSubArray(nums, lo, mi);
        int maxRight = maxSubArray(nums, mi + 1, hi);
        int maxCrossing = maxCrossingArray(nums, lo, mi, hi);

        return Math.max(maxLeft, Math.max(maxRight, maxCrossing));
    }

    private static int maxCrossingArray(int[] nums, int lo, int mi, int hi) {
        int maxLeft = nums[mi];
        int accu = nums[mi];
        for (int i = mi - 1; i >= lo; i--) {
            accu += nums[i];
            if (accu > maxLeft) {
                maxLeft = accu;
            }
        }

        int maxRight = nums[mi + 1];
        accu = nums[mi + 1];
        for (int i = mi + 2; i <= hi; i++) {
            accu += nums[i];
            if (accu > maxRight) {
                maxRight = accu;
            }
        }

        return maxLeft + maxRight;
    }


    //wrong
    public static int maxSubArrayWrong(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mi = lo + (hi - lo) / 2;

        int lIndex = mi;
        int rIndex = mi + 1;

        int lSum = nums[lIndex], rSum = nums[rIndex];
        int lMax = lSum, rMax = rSum;

        while (lIndex != lo) {
            lSum += nums[lIndex];
            lMax = Math.max(lSum, lMax);

            lIndex--;
        }

        while (rIndex != hi) {
            rSum += nums[rIndex];
            rMax = Math.max(rSum, rMax);

            rIndex++;
        }

        return maxSubArray(nums, lo, mi) + maxSubArray(nums, mi + 1, hi);
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

}