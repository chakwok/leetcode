package medium;

import java.util.Arrays;

public class Q1101TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (logX, logY) -> logX[0] - logY[0]);

        int groups = n;
        RankedDisjointSet ds = new RankedDisjointSet(n);
        for(int[] log : logs) {
            boolean isGrouped = ds.union(log[1], log[2]);
            if(isGrouped) groups--;

            if(groups == 1) {
                return log[0];
            }
        }
        return -1;
    }

}
class RankedDisjointSet {
    int[] root;
    int[] height;

    public RankedDisjointSet(int n) {
        root = new int[n];
        height = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
            height[i] = 1;
        }

    }

    private int find(int x) {
        if(x == root[x]) {
            return x;
        }

        return root[x] = find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) {
            return false;
        }

        int diff = height[rootX] - height[rootY];
        if(diff > 0) {
            root[rootY] = rootX;
        } else if(diff < 0) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            height[rootX]++;
        }
        return true;
    }
}
