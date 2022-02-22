package medium;

public class Q361BombEnemy {
    public static void main(String[] args) {
        var app = new Q361BombEnemy();
        System.out.println(app.maxKilledEnemies(new char[][]{{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}}));
        System.out.println(app.maxKilledEnemies(new char[][]{{'W','W','W'},{'0','0','0'},{'E','E','E'}}));
    }

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ver = new int[m][n];
        int[][] hor = new int[m][n];

        for(int i = 0; i < m; i++) {
            int cached = -1;
            int prev = 0;
            for(int j = 0; j < n; j++) {
                char ch = grid[i][j];
                if(ch == 'W') {
                    cached = -1;
                    prev = 0;
                    continue;
                } else if(ch == 'E') {
                    if(cached != -1) {
                        cached--;
                    }
                    prev++;
                    continue;
                }

                if(cached == -1) {
                    int k = j + 1;
                    cached = 0;
                    while(k < n && grid[i][k] != 'W') {
                        if(grid[i][k] =='E') {
                            cached++;
                        }
                        k++;
                    }

                }
                hor[i][j] = cached + prev;
            }
        }

        for(int i = 0; i < n; i++) {
            int cached = -1;
            int prev = 0;
            for(int j = 0; j < m; j++) {
                char ch = grid[j][i];
                if(ch == 'W') {
                    cached = -1;
                    prev = 0;
                    continue;
                } else if(ch == 'E') {
                    if(cached != -1) {
                        cached--;
                    }
                    prev++;
                    continue;
                }

                if(cached == -1) {
                    int k = j + 1;
                    cached = 0;
                    while(k < m && grid[k][i] != 'W') {
                        if(grid[k][i] =='E') {
                            cached++;
                        }
                        k++;
                    }

                }
                ver[j][i] = cached + prev;
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    max = Math.max(max, hor[i][j] + ver[i][j]);
                }
            }
        }
        return max;
    }
}
