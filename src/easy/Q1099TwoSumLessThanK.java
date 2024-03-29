package easy;

import java.util.Arrays;

public class Q1099TwoSumLessThanK {
    public static void main(String[] args) {
        System.out.println(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60));
        System.out.println(twoSumLessThanK(new int[]{10, 20,30}, 15));
    }
    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int front = 0;
        int back = nums.length - 1;

        int out = -1;
        while(back > front) {
            int sum = nums[front] + nums[back];
            if(sum == k - 1) {
                return sum;
            }

            if(sum >= k) {
                back--;
            } else {
                out = Math.max(out, sum);
                front++;
            }
        }

        return out;
    }


    public static int twoSumLessThanKSlow(int[] A, int K) {
        int maxS = Integer.MIN_VALUE;

        int min = Integer.MIN_VALUE;
        boolean[] exceedK = new boolean[A.length];
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= K) {
                exceedK[i] = true;
                min = Math.min(A[i], min);
            }
        }

        for(int i = 0; i < A.length; i++) {
            if(exceedK[i] == true || A[i] + min > K) {
                continue;
            }
            for(int j = i + 1; j < A.length; j++) {
                if(A[i] + A[j] < K) {
                    maxS = Math.max(A[i] + A[j], maxS);
                }

            }
        }
        if(maxS == Integer.MIN_VALUE) {
            return -1;
        }
        return maxS;
    }
}
