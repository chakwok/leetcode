package easy;
import java.util.Arrays;

class Q1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        Arrays.sort(newNums);
        int index;
        for (int i = 0; i < newNums.length; i++) {
            index = Arrays.binarySearch(newNums, target - newNums[i]);
            if (index >= 0 && index != i) {
                int[] toReturn = new int[2];
                int num1 = newNums[i];
                int num2 = newNums[index];
                boolean gotNum1 = false;
                boolean gotNum2 = false;
                for (int j = 0; j < nums.length; j++) {

                    if (nums[j] == num1 && !gotNum1) {
                        toReturn[0] = j;
                        gotNum1 = true;
                    } else if (nums[j] == num2) {
                        toReturn[1] = j;
                        gotNum2 = true;
                    }

                    if (gotNum1 && gotNum2) {
                        return toReturn;
                    }
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    }
}