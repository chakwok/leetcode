package Medium;

public class Q162FindPeakElement {
    public int findPeakElement(int[] nums) {
        for(int i = 1; i < nums.length;) {
            if(nums[i] > nums[i + 1]) {
                if(nums[i] > nums[i - 1]) {
                    return i;
                }
                i += 1;
            } else {
                i += 2;
            }
        }
        //not gonna happen
        return -99;
    }

}
