package medium;

import java.util.Arrays;

public class Q80RemoveDuplicatesfromSortedArrayII{
    public static void main(String[] args) {
        var app = new Q80RemoveDuplicatesfromSortedArrayII();
        var arr = new int[] {0,0,1,1,1,1,2,3,3};
        System.out.println(app.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        int slow = 1;
        int prev = nums[0];
        int occurence = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev) {
                occurence++;
            } else {
                occurence = 1;
            }

            if(occurence <= 2) {
                nums[slow++] = nums[i];
            }


            prev = nums[i];
        }
        return slow;
    }
}