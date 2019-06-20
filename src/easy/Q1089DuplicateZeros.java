package easy;

import java.util.Arrays;

public class Q1089DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                zeros++;
            }
        }

        int[] result = new int[arr.length + zeros];
        int pos = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                result[pos++] = 0;
                result[pos++] = 0;
            } else {
                result[pos++] = arr[i];
            }
        }

        System.arraycopy(result, 0, arr, 0, arr.length);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
