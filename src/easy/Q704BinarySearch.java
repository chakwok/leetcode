package easy;

public class Q704BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        int mi;
        while (lo != hi) {
            mi = lo + (hi - lo) / 2;

            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return (nums[lo] == target)? lo: -1;
    }
}
