package medium;

public class Q289GameofLife{
    static final int[][] DIRS = new int[][]{new int[] {-1,-1},new int[] {-1,0},new int[] {-1,1},new int[] {0,-1},new int[] {0,1},new int[] {1,-1},new int[] {1,0},new int[] {1,1}};
    int n;
    int m;
    static final int MAX = 4;
    // 2 can use 3-6
    /*
    * 3: give score, next = dead
    * 4: don't give, next dead (invalid)
    * 5: give score, alive
    * 6: don't give score, alive
    *
    * */
    public void gameOfLife(int[][] board) {
        n = board.length;
        m = board[0].length;


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int ns = neighborSum(board, i, j);
                boolean live = board[i][j]%2 == 1;
                if(ns == 3) {
                    board[i][j] = 5 + (live? 0 : 1);
                } else if(live) {
                    if(ns < 2 || ns > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = board[i][j];
                if(curr == 5 || curr == 6) {
                    board[i][j] = 1;
                } else if(curr == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int neighborSum(int[][] board, int i, int j) {
        int score = 0;
        for(int[] dir : DIRS) {
           int a = i + dir[0];
           int b = j + dir[1];

           if(a >= 0 && a < n && b >= 0 && b < m) {
               score += board[a][b]%2;
               if(score >= MAX) {
                    return score;
               }
           }
        }
        return score;
    }

    public static void main(String[] args) {
        var app = new Q289GameofLife();
        app.gameOfLife(new int[][]{new int[] {0,1,0}, new int[] {0,0,1}, new int[] {1,1,1}, new int[]{0,0,0}});
        app.gameOfLife(new int[][]{new int[] {1,1}, new int[] {1,0}});
    }
}