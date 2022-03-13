package medium;

import java.util.Arrays;

public class Q31NextPermutation{
    public static void main(String[] args) {
        var app = new Q31NextPermutation();
        var arr = new int[]{1,2,3};
        app.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1,3,2};
        app.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i+1] > nums[i]) {
                int minGtIdx = i + 1;
                for(int j = i + 1; j < n; j++) {
                    if(nums[j] > nums[i]) {
                        if(nums[j] <= nums[minGtIdx]) {
                            minGtIdx = j;
                        }
                    }
                }
                swap(nums, i, minGtIdx);
                reverse(nums, i + 1);
                return;
            }
        }
        reverse(nums,0);
    }

    private void reverse(int[] nums, int from) {
        int end = nums.length - 1;
        while (from < end) {
            swap(nums, from++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}