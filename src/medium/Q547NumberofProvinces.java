package medium;

import java.util.HashSet;

public class Q547NumberofProvinces {

    public static void main(String[] args) {
        var app = new Q547NumberofProvinces();
        System.out.println(app.findCircleNum(new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashSet<Integer> visited = new HashSet<>();
        int out = 0;
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                out++;
                for(int j = i + 1; j < n; j++) {
                    if(isConnected[i][j] == 1 && !visited.contains(j)) {
                        visit(isConnected, j, visited);
                    }
                }
            }
        }
        return out;
    }

    private void visit(int[][] isConnected, int i, HashSet<Integer> visited) {
        int n = isConnected.length;
        visited.add(i);

        for(int j = 0; j < n; j++) {
            if(i == j) continue;
            if(isConnected[i][j] == 1 && !visited.contains(j)) {
                visit(isConnected, j, visited);
            }
        }
    }
}
