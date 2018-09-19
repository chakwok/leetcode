package Medium;

public class Q33SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null ) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        int mi;

        while (lo < hi) {
            mi = lo + (hi - lo / 2);
            if(nums[mi] == target) {
                return mi;
            } else if(target > nums[hi]) {
                hi = mi;
            } else if(target < nums[hi]) {
                lo = mi + 1;
            }
        }

        return -1;
    }
}
