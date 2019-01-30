package medium;

import java.util.Arrays;

public class Q34FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] toReturn = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return toReturn;
        }

        int lo = 0;
        int hi = nums.length - 1;
        int mi;

        //search Low
        while (lo != hi) {
            mi = lo + (hi - lo)/2;

            if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        // not found
        if(nums[lo] != target) {
            return toReturn;
        }

        toReturn[0] = lo;

        //search High
        lo = 0;
        hi = nums.length - 1;

        while (lo != hi) {
            mi = lo + (int)Math.ceil(((double)hi - lo)/2);
            //mi = lo + (hi - lo) / 2;

            if (nums[mi] > target) {
                hi = mi - 1;
            } else {
                lo = mi;
            }
        }

        toReturn[1] = lo;



        return toReturn;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        //int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}
