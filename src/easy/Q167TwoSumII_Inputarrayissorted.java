package easy;

import java.util.Arrays;

public class Q167TwoSumII_Inputarrayissorted {
    //Time Complexity: O(n)
    //Since we are summing 2 numbers from the array, the extra property of (sum <> target) can
    //eliminate the use of binarySearch. Instead we can simply loop thru the list.
    public int[] twoSum(int[] numbers, int target) {
        int small = 0, big = numbers.length - 1;
        int sum;
        while (small < big) {
            if((sum = numbers[small] + numbers[big]) > target ) {
                big--;
            } else if (sum < target) {
                small++;
            } else {
                return new int[] {small + 1, big + 1};
            }
        }
        return new int[2];
    }

    //Time Complexity: O(NlogN)
    public int[] twoSumOld(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int result = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if(result >= 0) {
                return new int[]{i + 1, result + 1};
            }
        }
        return new int[] {-37, -37};
    }

}
