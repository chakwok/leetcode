package Medium;

public class Q153FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if(nums[lo] < nums[hi]) {
            return nums[lo];
        }

        int mi = lo + (hi - lo) / 2;

        int pivot = nums[0];

        while(lo < hi) {
            mi = lo + (hi - lo) / 2;
            if(nums[mi] >= pivot) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        //int ans = findMin(new int[] {3,4,5,1,2, 3});
        int ans = findMin(new int[] {4, 0, 1, 2, 3});
        System.out.println(ans);
    }
}
