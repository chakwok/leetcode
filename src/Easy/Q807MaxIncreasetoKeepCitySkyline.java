package Easy;

public class Q807MaxIncreasetoKeepCitySkyline {


    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] skylines = calculateSkylines(grid);
        int maxIn = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                maxIn += Math.min(skylines[1][i], skylines[0][j]) - grid[i][j];
            }
        }
        return maxIn;
    }

    private static int[][] calculateSkylines(int[][] grid) {
        int[][] skylines = new int[2][grid[0].length]; //[top, left]

        for(int i = 0; i < grid.length; i++) {
            int maxHori = 0;
            for(int j = 0; j < grid[0].length; j++) {
                //keep track of max horizontal height
                if(grid[i][j] > maxHori) {
                    maxHori = grid[i][j];
                }

                //update max top height
                if(grid[i][j] > skylines[0][j]) {
                    skylines[0][j] = grid[i][j];
                }
            }
            skylines[1][i] = maxHori;

        }

        return skylines;
    }

    public static void main(String[] args){
        int ans = maxIncreaseKeepingSkyline(new int[][] {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}});
        System.out.println(ans);
    }


}
