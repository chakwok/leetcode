package medium;

public class Q154FindMinimuminRotatedSortedArrayII {
    public static int findMinNew(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mi = 0;

        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            } else if (nums[mi] < nums[hi]) {
                hi = mi;
            } else if (nums[mi] == nums[hi]) { //nums[hi] should be used here instead of nums[nums.length - 1]
                //as we are trying to converge the answer to smallest
                hi--;
            }
        }
        return nums[lo];
    }


    /*
        This code is correct to return the minimum value of the array. But in terms of "find the minimum value index" it is not right.
        Consider this case: 1 1 1 1 1 1 1 1 2 1 1
        the min index returned is 0, while actually it should be 9.
        For this case: 2 2 2 2 2 2 2 2 1 2 2
        it will return the correct index, which is 8.

        The reason is, the pivot index will be passed by at hi--. To avoid this, we can add the following judgement:

        else {

        if (nums[hi - 1] > nums[hi]) {
            lo = hi;
            break;
        }
        hi--;
    */


    private static int minSoFar;

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        //not rotated
        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }

        minSoFar = Math.min(nums[lo], nums[hi]);

        findMin(nums, lo, hi);

        return minSoFar;
    }

    private static void findMin(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mi = lo + (hi - lo) / 2;
        if (nums[mi] < minSoFar) {
            minSoFar = nums[mi];
        }

        if (nums[mi] == nums[0]) {
            findMin(nums, mi + 1, hi);
            findMin(nums, lo, mi);
        }
        if (nums[mi] > nums[0]) {
            findMin(nums, mi + 1, hi);
        } else {
            findMin(nums, lo, mi);
        }
    }

    public static void main(String[] args) {
        //int ans = findMin(new int[] {3,4,5,1,2, 3});
        int ans = findMin(new int[]{2, 2, 2, 0, 1});
        System.out.println(ans);
    }
}
