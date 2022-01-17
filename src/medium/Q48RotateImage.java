package medium;

public class Q48RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }

        int n = matrix.length;
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < n/2 + n%2; j++) {
                int tmp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void rotateTwoStep(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }

        transpose(matrix);

        for (int[] arr : matrix) {
            reverse(arr);
        }
    }

    private void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    private void reverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            int idxEnd = arr.length - 1 - i ;
            int tmp = arr[idxEnd];
            arr[idxEnd] = arr[i];
            arr[i] = tmp;
        }
    }
}
