package easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q283MoveZeroes {
    //heapsort with comparator 0 with value inf
    //mergesort

    
    //worst case runtime: O(nlogn) (all zeros)
    private static PriorityQueue<Integer> lowestZeroes = new PriorityQueue<>();

    public static void moveZeroes(int[] nums) {
        //TODO: better understand the solution
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        //int countZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                lowestZeroes.add(i);
                //countZero++;
            } else {
                if(!lowestZeroes.isEmpty()) {
                    swap(nums, i, lowestZeroes.poll());
                    lowestZeroes.add(i);
                }
            }
        }

        //Arrays.sort(nums, 0, countZero);
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 1};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
