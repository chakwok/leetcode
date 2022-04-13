package medium;

import java.util.Arrays;

public class Q59SpiralMatrixII{
    public static void main(String[] args) {
        var app = new Q59SpiralMatrixII();
        System.out.println(Arrays.deepToString(app.generateMatrix(1)));
        System.out.println(Arrays.deepToString(app.generateMatrix(3)));
        System.out.println(Arrays.deepToString(app.generateMatrix(2)));
        System.out.println(Arrays.deepToString(app.generateMatrix(4)));
    }
    public int[][] generateMatrix(int n) {
        int k = 1;
        int iMin = 0 ;
        int iMax = n - 1;
        int jMin = 0;
        int jMax = n - 1;
        int[][] out = new int[n][n];
        while(k <= n*n) {
            for(int j = jMin; j <= jMax; j++) {
                out[iMin][j] = k++;
            }
            iMin++;

            for(int i = iMin; i <= iMax; i++) {
               out[i][jMax] = k++;
           }
            jMax--;
            for(int j = jMax; j >= jMin; j--) {
                out[iMax][j] = k++;
            }
            iMax--;

            for(int i = iMax; i >= iMin; i--) {
                out[i][jMin] = k++;
            }
            jMin++;

        }
        return out;
    }
}