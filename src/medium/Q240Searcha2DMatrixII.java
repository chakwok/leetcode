package medium;

public class Q240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int width = matrix[0].length;;
        int height = matrix.length;

        if(target < matrix[0][0] || target > matrix[height - 1][width - 1]) {
            return false;
        }

        //range for the search
        int xlo = 0; int xhi = width - 1;
        int ylo = 0; int yhi = height - 1;

        // determine ylo
        for(int i = 0; i < height - 1; i++ ) {
            if(target > matrix[i][width - 1]) {
                ylo++;
            } else {
                break;
            }
        }

        //yhi
        for(int i = height - 1; i > 0; i--) {
            if(target < matrix[i][0]) {
                yhi--;
            } else {
                break;
            }
        }

        for(int i = 0; i < width - 1; i++) {
            if(target > matrix[height - 1][i]) {
                xlo++;
            } else{
                break;
            }
        }

        for(int i = width - 1; i > 0; i--) {
            if(target < matrix[0][i]) {
                xhi--;
            } else{
                break;
            }
        }

        for(int i = ylo; i <= yhi ; i++) {
            if(binarySearch(matrix[i], target, xlo, xhi)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int target, int xlo, int xhi) {
        while(xlo <= xhi) {
            if(row[xlo] == target) {
                return true;
            }

            int mi = xlo + (xhi - xlo)/ 2;

            if(row[mi] == target) {
                return true;
            } else if(row[mi] < target) {
                xlo = mi + 1 ;
            } else if(row[mi] > target) {
                xhi = mi - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q240Searcha2DMatrixII app = new Q240Searcha2DMatrixII();
        boolean ans = app.searchMatrix(new int[][]
                {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20);
        System.out.println(ans);
    }
}
