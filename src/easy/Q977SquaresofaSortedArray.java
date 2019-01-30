package easy;

import java.util.Arrays;

public class Q977SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int splitIndex = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] < 0) {
                A[i] = -A[i];
            } else {
                //first non-negative element
                splitIndex = i;
                break;
            }
        }

        return mergeAndSquare(A, splitIndex);
    }

    public int[] mergeAndSquare(int[] A, int split) {
        int[] result = new int[A.length];
        int filled = 0;

        int splitForward = split;
        int splitBackward = split - 1;

        while(splitForward < A.length && splitBackward >= 0) {
            if(A[splitForward] < A[splitBackward]) {
                result[filled] = (int) Math.pow(A[splitForward], 2);
                splitForward++;
            } else {
                result[filled] = (int) Math.pow(A[splitBackward], 2);
                splitBackward--;
            }
            filled++;
        }

        if(splitForward == A.length) {
            while(splitBackward >= 0) {
                result[filled] = (int) Math.pow(A[splitBackward], 2);
                splitBackward--;
                filled++;
            }
        } else if(splitBackward == -1) {
            while(splitForward < A.length) {
                result[filled] = (int) Math.pow(A[splitForward], 2);
                splitForward++;
                filled++;
            }
        } else {
            throw new RuntimeException("this is weird");
        }

        return result;
    }

    public static void main(String[] args) {
        Q977SquaresofaSortedArray me = new Q977SquaresofaSortedArray();
        int[] ans = me.sortedSquares(new int[]{-4,-1,0,3,10});
        System.out.println(Arrays.toString(ans));

    }
}
