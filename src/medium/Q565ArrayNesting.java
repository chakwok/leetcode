package medium;

import java.util.HashSet;

public class Q565ArrayNesting {
    //runtime:O(n), space:O(n)，beating 9x% submissions
    public static int arrayNesting(int[] nums) {
        //global var
        boolean[] occupied =  new boolean[nums.length];
        int unoccupiedCount = nums.length;
        int max = 0;

        //in-loop local var
        int currSetCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (occupied[i]) {
                continue;
            }

            int val = i;

            while (!occupied[val]) {
                occupied[val] = true;
                val = nums[val];
                currSetCount++;
            }

            //terminating case1: set.size() > half of nums.length
            if (currSetCount * 2 >= nums.length) {
                return currSetCount;
            }

            //terminating case2: max > unoccupied space
            max = Math.max(currSetCount, max);

            if (max > unoccupiedCount) {
                return max;
            }

            unoccupiedCount -= currSetCount;
            currSetCount = 0;
        }

        return max;
    }

    //runtime: O(n), space: O(n), beating 3x% submission
    public static int arrayNestingOld(int[] nums) {
        int[] memory =  new int[nums.length];
        int unoccupied = nums.length;
        int max = 0;

        HashSet<Integer> included = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (memory[i] != 0) {
                continue;
            }

            int val = i;


            included.add(val);

            while(!included.contains(nums[val])) {
                included.add(nums[val]);

                val = nums[val];
            }

            //terminating case1: set.size() > half of nums.length
            if (included.size() * 2 >= nums.length) {
                return included.size();
            }

            //terminating case2: max > unoccupied space
            max = Math.max(included.size(), max);

            if (max > unoccupied) {
                return max;
            }



            for(Integer element: included) {
                memory[element] = included.size();
            }

            unoccupied -= included.size();

            included.clear();
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[] {5,4,0,3,1,6,2}));
    }
}
