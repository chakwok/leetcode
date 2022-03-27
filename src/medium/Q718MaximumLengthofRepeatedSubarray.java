package medium;

public class Q718MaximumLengthofRepeatedSubarray{
    public static void main(String[] args) {
        var app = new Q718MaximumLengthofRepeatedSubarray();
        System.out.println(app.findLength(new int[]{1,0,1,0,1}, new int[]{0,1,1,1,1}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(nums1[i - 1] == nums2[j -1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Integer.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    public int findLength3toN(int[] nums1, int[] nums2) {
        return findLength(nums1, nums2, 0, 0, 0);
    }

    private int findLength(int[] nums1, int[] nums2, int idx1, int idx2) {
        if(idx1 >= nums1.length || idx2 >= nums2.length) {
            return 0;
        }

        int res = 0;
        if(nums1[idx1] == nums2[idx2]) {
            res = 1 + findLength(nums1, nums2, idx1 + 1, idx2 + 1);
        }

        int upLeft = findLength(nums1, nums2, idx1 + 1, idx2);
        int upRight = findLength(nums1, nums2, idx1, idx2 + 1);

        return Math.max(Math.max(res, upLeft), upRight);
    }

    private int findLength(int[] nums1, int[] nums2, int idx1, int idx2, int res) {
        if(idx1 >= nums1.length || idx2 >= nums2.length) {
            return res;
        }


        if(nums1[idx1] == nums2[idx2]) {
            res = findLength(nums1, nums2, idx1 + 1, idx2 + 1, res + 1);
        }

        int upLeft = findLength(nums1, nums2, idx1 + 1, idx2, 0);
        int upRight = findLength(nums1, nums2, idx1, idx2 + 1, 0);

        return Math.max(Math.max(res, upLeft), upRight);
    }
}