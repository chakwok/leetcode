package medium;

class Q912SortanArray {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if(lo == hi) {
            return;
        }

        int first = lo;
        int last = hi--;

        while(hi > lo) {
            while(lo < hi && nums[lo] < nums[last]) {
                lo++;
            }

            while(hi > lo && nums[hi] > nums[last]) {
                hi--;
            }

//            if(nums[hi] > nums[lo]) {
            int temp = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = temp;
//            }

            lo++;
        }
        if(nums[hi] > nums[last]) {
            int temp = nums[last];
            nums[last] = nums[hi];
            nums[hi] = temp;
        }


        quickSort(nums, first, hi);
        quickSort(nums, hi + 1, last);
    }

    private static  void mergeSort(int[] nums, int lo, int hi) {
        if(lo == hi) {
            return;
        }

        int mi = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mi);
        mergeSort(nums, mi + 1, hi);

        merge(nums, lo, mi, mi + 1, hi);
    }

    private static void merge(int[] nums, int lo1, int hi1, int lo2, int hi2) {
        int[] res = new int[hi2 - lo1 + 1];
        int idx = 0;
        int low = lo1;
        while(lo1 <= hi1 && lo2 <= hi2) {
            if(nums[lo1] <= nums[lo2]) {
                res[idx++] = nums[lo1++];
            } else {
                res[idx++] = nums[lo2++];
            }
        }

        if(lo1 <= hi1) {
            System.arraycopy(nums, lo1, res, idx, hi1 - lo1 + 1);
        } else {
            System.arraycopy(nums, lo2, res, idx, hi2 - lo2 + 1);
        }

        System.arraycopy(res, 0, nums, low, res.length);

    }
}