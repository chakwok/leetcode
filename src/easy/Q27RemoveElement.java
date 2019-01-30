package easy;

import java.util.Arrays;

public class Q27RemoveElement {
    //TODO: reread this
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            if(nums[0] == val) {
                return 0;
            }
            return 1;
        }

        int frontIndexPtr = 0;
        int endIndexPtr = nums.length - 1;
        int countOfVal = 0;

        //as it's possible that end-- and front++ happen at the same time, <= is needed.
        while(frontIndexPtr < endIndexPtr) {
            if(nums[frontIndexPtr] == val) {
                countOfVal++;
                while(nums[endIndexPtr] == val)
                {
                    countOfVal++;
                    endIndexPtr--;
                    if(frontIndexPtr == endIndexPtr) {
                        return nums.length - countOfVal;
                    }

                }
                arrSwap(nums, frontIndexPtr, endIndexPtr);
                endIndexPtr--;
            } else {
                frontIndexPtr++;
            }
        }

        if(nums[frontIndexPtr] == val) {
            countOfVal++;
        }



        return nums.length - countOfVal;
    }


    public int removeElement2(int[] nums, int val) {
        int lastIndex = nums.length - 1;
        int count = 0;
        int temp;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                //swap
                //potentially out of bound.
                while(nums[lastIndex] == val) {
                    nums[lastIndex]--;
                }
                temp = nums[i];
                nums[i] = nums[lastIndex];
                nums[lastIndex] = temp;

                count++;
                lastIndex--;
            }
        }


        return count;
    }


    private static void arrSwap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    //[3] 3

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        int ans = removeElement(nums, 1);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
}

