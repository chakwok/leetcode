package medium;

public class Q153FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            //if the list is even-numbered, the mid point will always select the left mid-point
            //therefore, sometimes it's comparing with itself. It's better to compare nums[mi] with
            // the nums[hi] than nums[low] as it will guarantee that it always converge to smallest val
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static int findMin2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
/*
        if(nums[lo] < nums[hi]) {
            return nums[lo];
        }*/

        int mi = lo + (hi - lo) / 2;

        int pivot = nums[0];

        while(lo < hi) {
            mi = lo + (hi - lo) / 2;
            if(nums[mi] > pivot) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        //int ans = findMin(new int[] {3,4,5,1,2, 3});
        int ans = findMin2(new int[] {1,2});
        System.out.println(ans);
    }
}
