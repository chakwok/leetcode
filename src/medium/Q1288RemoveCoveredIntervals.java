package medium;

import java.util.Arrays;

public class Q1288RemoveCoveredIntervals {
    public static void main(String[] args) {
        var app = new Q1288RemoveCoveredIntervals();
        System.out.println(app.removeCoveredIntervals(new int[][]{{1,4}, {3,6}, {2,8}}));
        System.out.println(app.removeCoveredIntervals(new int[][]{{1,4}, {2,3}}));
        System.out.println(app.removeCoveredIntervals(new int[][]{{1,2}, {1,4}, {3,4}}));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] != i2[0]) {
                return i1[0] - i2[0];
            } else return i2[1] - i1[1];
        });

        int out = 1;
        int max = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][1] > max) {
                out++;
            }

            max = Math.max(max, intervals[i][1]);
        }

        return out;
    }
}
