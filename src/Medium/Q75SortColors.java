package Medium;

import java.util.Arrays;

public class Q75SortColors {
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int front = 0;
        int end = nums.length - 1;

        for (int i = 0; i <= end && front <= end;) {
            if (nums[front] == 0) {
                front++;
                if(i < front) {
                    i = front;
                }
            } else if (nums[end] == 2) {
                end--;
            } else if (nums[i] == 0) {
                nums[i] = nums[front];
                nums[front] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
            } else {
                i++;
            }

        }
    }

    //It's not a good style to nest while+if inside a for-loop
    public static void sortColorsDep(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int front = 0;
        int end = nums.length - 1;

        for(int i = 0; i < end; i++) {
            while (nums[front] == 0) {
                front++;
                if(front > end) {
                    break;
                }
            }

            if (i < front) {
                i = front;
            }

            while (nums[end] == 2) {
                end--;
                if (i > end) {
                    break;
                }
            }

            if (i > end) {
                break;
            }



            if (nums[i] == 0) {
                nums[i] = nums[front];
                nums[front] = 0;
                front++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }
        }

    }

    public static void main(String[] args) {
//        int[] arr = new int[] {2,0,1};
        int[] arr = new int[] {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }


}
