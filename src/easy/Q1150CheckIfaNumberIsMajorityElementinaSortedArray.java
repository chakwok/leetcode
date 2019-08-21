package easy;

public class Q1150CheckIfaNumberIsMajorityElementinaSortedArray {
//    O(log(n))
    public boolean isMajorityElement(int[] nums, int target) {
        int hi = rightLeaningBinarySearch(nums, target);
        if(hi == -1) {
            return false;
        }

        int lo = leftLeaningBinarySearch(nums, target);

        int count = hi - lo + 1;
        return count > nums.length/ 2;
    }

    private int leftLeaningBinarySearch(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;

        int matched = -1;

        while(hi != lo) {
            int mi = lo + (hi - lo)/ 2;
            int val = nums[mi];

            if(val == target) {
                matched = mi;
            }

            if(target <= val) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        if(nums[lo] == target) {
            matched = lo;
        }

        return matched;
    }

    private int rightLeaningBinarySearch(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;

        int matched = -1;

        while(hi != lo) {
            int mi = lo + (hi - lo)/ 2;
            int val = nums[mi];

            if(val == target) {
                matched = mi;
            }

            if(target < val) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        if(nums[hi] == target) {
            matched = hi;
        }

        return matched;
    }


    // O(n) unneccessary
    public boolean isMajorityElementOld(int[] nums, int target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
            }

            if(count > nums.length/2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q1150CheckIfaNumberIsMajorityElementinaSortedArray app = new Q1150CheckIfaNumberIsMajorityElementinaSortedArray();
        System.out.println(app.isMajorityElement(new int[]{2,4,5,5,5,5,5,6,6}, 5));
        System.out.println(app.isMajorityElement(new int[]{10, 100, 101, 101}, 5));
    }
}
