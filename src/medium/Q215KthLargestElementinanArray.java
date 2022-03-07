package medium;

public class Q215KthLargestElementinanArray{
    public static void main(String[] args) {
        var app = new Q215KthLargestElementinanArray();
        System.out.println(app.findKthLargest(new int[]{7,6,5,4,3,2,1}, 2));
        System.out.println(app.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(app.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int l, int r) {
        //select pivot
        int pivot = nums[r];

        //arrange arr according to pivot
        int slow = l;

        for(int i = l; i < r; i++) {
            if(nums[i] <= pivot) {
                swap(nums, slow++, i);
            }
        }
        swap(nums, r, slow);
        if(slow == k) {
            return nums[slow];
        } else if(slow < k) {
            return quickSelect(nums, k, slow + 1, r);
        } else {
            return quickSelect(nums, k, l, slow - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}