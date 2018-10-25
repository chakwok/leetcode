package Easy;

import java.util.Arrays;

public class Q88MergeSortedArray {
    //O(n + m) runtime, O(1) space
    public static void mergeNew(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        int curr1 = m -1, curr2 = n -1, start = m + n-1;
        while (curr1 >= 0 && curr2 >=0){
            if(nums1[curr1] > nums2[curr2]) nums1[start--] = nums1[curr1--];
            else nums1[start--] = nums2[curr2--];
        }
        if(curr1 <= 0) {
            //while(curr2>= 0) nums1[start--] = nums2[curr2--];
            if (curr2 >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, curr2 + 1);
            }

        }
    }

    //O(n + m) runtime, requires O(n) space
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        int index1 = 0;
        int index2 = 0;

        int[] arr = new int[m];
        System.arraycopy(nums1, 0, arr, 0, m);


        int i = 0;
        while (index1 < m && index2 < n) {
            if(arr[index1] < nums2[index2]) {
                nums1[i] = arr[index1];
                index1++;
            } else {
                nums1[i] = nums2[index2];
                index2++;
            }
            i++;
        }

        if (index1 >= m) {
            System.arraycopy(nums2, index2, nums1, i, n - index2);
        }

        if (index2 >= n) {
            System.arraycopy(arr, index1, nums1, i, m - index1);
        }
    }


    public static void mergeNW(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int index1 = 0;
        int index2 = 0;

        int temp;
        int index2ToSwap;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                index1++;
            } else {
                //if index2 is not the last element, check index2 and index2 + 1
                if(index2 < n) {

                }

                temp = nums1[index1];
                nums1[index1] = nums2[index2];
                nums2[index2] = temp;
                index1++;
                //index1++;
            }
        }



        if (index1 >= m) {
            System.arraycopy(nums2, index2, nums1, m, n - index2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {2, 0};//{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[] {1};
        System.out.println(Arrays.toString(nums1));
        mergeNew(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
