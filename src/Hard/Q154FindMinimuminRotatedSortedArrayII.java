package Hard;

public class Q154FindMinimuminRotatedSortedArrayII {
    private static int minSoFar;
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        //not rotated
        if(nums[lo] < nums[hi]) {
            return nums[lo];
        }

        minSoFar = Math.min(nums[lo], nums[hi]);


        findMin(nums, lo, hi);

        return minSoFar;
    }

    private static void findMin(int[] nums, int lo, int hi) {
        if(lo == hi) {
            return;
        }

        int mi = lo + (hi - lo) / 2;
        if(nums[mi] < minSoFar) {
            minSoFar = nums[mi];
        }

        if(nums[mi] == nums[0]) {
            findMin(nums, mi + 1, hi);
            findMin(nums, lo, mi);
        }
        if(nums[mi] > nums[0]) {
            findMin(nums, mi + 1, hi);
        } else {
            findMin(nums, lo, mi);
        }
    }

    public static void main(String[] args) {
        //int ans = findMin(new int[] {3,4,5,1,2, 3});
        int ans = findMin(new int[] {2, 2, 2, 0, 1});
        System.out.println(ans);
    }
}
