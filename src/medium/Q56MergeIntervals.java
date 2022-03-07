package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class Q56MergeIntervals{
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        ArrayDeque<int[]> ans = new ArrayDeque<>();
        ans.add(intervals[0]);


        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = ans.getLast();

            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                ans.add(curr);
            }
        }

        return ans.toArray(new int[][]{});
    }
}