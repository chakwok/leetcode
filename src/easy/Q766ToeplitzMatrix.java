package easy;

public class Q766ToeplitzMatrix{
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int j = 0; j < n; j++) {
            if(!isToeplitzEntry(matrix, 0, j)) {
                return false;
            }
        }
        for(int i = 0; i < m; i++) {
            if(!isToeplitzEntry(matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean isToeplitzEntry(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;

        int val = matrix[i++][j++];
        while(i < m && j < n) {
            if(matrix[i][j] != val) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}