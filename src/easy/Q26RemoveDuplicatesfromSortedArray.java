package easy;

public class Q26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int unique = 0;
//        int idx = 0; //slow pointer

        for(int i = 0; i < nums.length; i++) {
            while(i != nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
            nums[unique] = nums[i];
            unique++;
        }

        return unique;
    }
}
