package medium;

import java.util.LinkedList;

public class Q1762BuildingsWithanOceanView {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        LinkedList<Integer> out = new LinkedList<>();
        out.add(n - 1);
        int max = heights[heights.length - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(heights[i] > max) {
                out.addFirst(i);
            }
            max = Math.max(max, heights[i]);
        }
        int[] ans = new int[out.size()];
        int idx = 0;
        for(int i : out) {
            ans[idx++] = i;
        }
        return ans;
    }
}
