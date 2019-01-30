package easy;

public class Q35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 ) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int lo = 0;
        int hi = nums.length - 1;
        int mi;

        while(lo != hi ) {
            mi = lo + (hi - lo) / 2;

            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        if (nums[lo] >= target) {
            return lo;
        } else {
            return lo + 1;
        }


    }
}
