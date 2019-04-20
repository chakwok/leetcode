package medium;

public class Q200NumberofIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        //map of checked pos
        //dynamically updated by islandFound method
        //0: needed to be checked 1: doesn't
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        int numIsland = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(checked[i][j] == false && grid[i][j] == '1') {
                    exploreAnIsland(grid, checked, i, j);
                    numIsland++;
                }

            }
        }

        return numIsland;


    }

    private void exploreAnIsland(char[][] grid, boolean[][] checked, int x, int y) {
        if(checked[x][y] == true) {
            return;
        } else if(grid[x][y] == '0') {
            checked[x][y] = true;
            return;
        }

        checked[x][y] = true;

        if(x > 0 ) {
            exploreAnIsland(grid, checked, x - 1, y);
        }

        if(x < grid.length - 1) {
            exploreAnIsland(grid, checked, x + 1, y);
        }


        if(y > 0) {
            exploreAnIsland(grid, checked, x, y - 1);
        }

        if(y < grid[0].length - 1) {
            exploreAnIsland(grid, checked, x, y + 1);
        }
    }




}
