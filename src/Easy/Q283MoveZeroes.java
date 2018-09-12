package Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q283MoveZeroes {
    //heapsort with comparator 0 with value inf
    //mergesort

    

    private static PriorityQueue<Integer> lowestZeroes = new PriorityQueue<>();

    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                lowestZeroes.add(i);
            } else {
                if(!lowestZeroes.isEmpty()) {
                    swap(nums, i, lowestZeroes.poll());
                    lowestZeroes.add(i);
                }
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 12, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
