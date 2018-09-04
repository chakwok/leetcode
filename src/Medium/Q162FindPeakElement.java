package Medium;

public class Q162FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        } else if(nums[0] > nums[1]) {
            return 0;
        } else if(nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        //given that nums[-1] and nums[n] is -inf, we can use binary search
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] < nums[middle + 1]) {
                low = middle + 1; // to avoid infinite loop; since we know that middle + 1 is still
                // increasing so we can just search from middle + 1 instead of
                // from middle
            } else {
                if (nums[middle] > nums[middle - 1]) {
                    return middle;
                }
                high = middle;
            }
        }
        return low;
    }



    public static void main(String[] args) {
        Q162FindPeakElement instance = new Q162FindPeakElement();
        int ans = instance.findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(ans);
    }

}
