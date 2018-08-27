package Easy;

import java.util.Arrays;

public class Q633SumofSquareNumbers {
/*    public static boolean judgeSquareSum(int c) {
        long[] arr = new long[(int)Math.ceil(Math.sqrt(c) + 1)];
        for (long i = 0, j = 0; j < (long) c; i++) {
            j = i * i;
            arr[(int)i] = j;
           // System.out.println(i + "    " + j );
        }
        int k;
        for (int i = 0; i < arr.length; i++ ) {
            if ((Arrays.binarySearch(arr, c - arr[i])) >= 0) {
                return true;
            }
        }
        return false;
    }*/
    public static boolean judgeSquareSum(int c) {
        int[] arr = new int[(int)Math.ceil(Math.sqrt(c) + 1)];
        for (int i = 0, j = 0; j < c; i++) {
            j = i * i;
            if (j < 0) {
                break;
            }
            arr[i] = j;
        }
        int k;
        for (int i = 0; i < arr.length; i++ ) {
            if ((Arrays.binarySearch(arr, c - arr[i])) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        judgeSquareSum(2147482647);
    }
}