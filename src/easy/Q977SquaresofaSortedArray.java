package easy;

import java.util.Arrays;

public class Q977SquaresofaSortedArray{
    public static void main(String[] args) {
        var app = new Q977SquaresofaSortedArray();
        System.out.println(Arrays.toString(app.sortedSquares(new int[]{-1})));
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];

        int firstPositive = -1;
        for(int i = 0; i < n; i++) {
            if(firstPositive == -1 && nums[i] >= 0) {
                firstPositive = i;
            }
            nums[i] = (int) Math.pow(nums[i], 2.0);
        }

        if(firstPositive == -1) {
            for(int i = 0; i < n ; i++) {
                out[i] = nums[n - 1 - i];
            }
            return out;
        }

        int front = firstPositive;
        int back = firstPositive - 1;
        int i = 0;
        while(front < n && back >= 0) {
            if(nums[front] > nums[back]) {
                out[i++] = nums[back--];
            } else {
                out[i++] = nums[front++];
            }
        }

        while(back >= 0) {
            out[i++] = nums[back--];
        }

        while(front < n) {
            out[i++] = nums[front++];
        }

       return out;
    }
}