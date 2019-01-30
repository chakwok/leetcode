package easy;

import java.util.Arrays;

public class Q905SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int end = A.length - 1;

        int temp;
        for (int i = 0; i < end; i++) {
            if(A[i] % 2 == 1) {
                while (A[end] % 2 == 1) {
                    end--;
                    if(i == end) {
                        return A;
                    }
                }

                //swap
                temp = A[i];
                A[i] = A[end];
                A[end] = temp;
                end--;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[] {0};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }
}