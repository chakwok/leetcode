package medium;

import java.util.Arrays;

public class Q189RotateArray {
    public static void main(String[] args) {
        System.out.println(-2%7);
        var app = new Q189RotateArray();
        var arr= new int[]{1,2,3,4,5,6,7};
        app.rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr= new int[]{1,2,3,4,5};
        app.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        if(k == 0) {
            return;
        }

        int numSwap = 0;
        int start = 0;
        //iteratively update next by (n-k)%n
        //stop when next = start
        while(numSwap < n) {
            int toUpdate = start;
            int curr = nums[toUpdate];
            int from = ((toUpdate-k)%n + n )%n;
            int prev = nums[from];
            nums[toUpdate] = prev;

            prev = curr;
            numSwap++;
            toUpdate = (start + k)%n;
            while(toUpdate != start) {
                int tmp = nums[toUpdate];
                nums[toUpdate] = prev;

                prev = tmp;
                numSwap++;
                toUpdate = (toUpdate + k)%n;
            }
            start++;
        }
    }
}
