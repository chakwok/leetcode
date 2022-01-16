package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Q452MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, Comparator.comparingInt(f -> f[1]));

        int thrown = points[0][1];
        int out = 1;

        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= thrown) {
                continue;
            }

            out++;
            thrown = points[i][1];
        }

        return out;
    }

    public static void main(String[] args) {
        Q452MinimumNumberofArrowstoBurstBalloons app = new Q452MinimumNumberofArrowstoBurstBalloons();
        System.out.println(app.findMinArrowShots(new int[][] {{1,2}, {3,4}, {5,6}, {7,8}}));
        System.out.println(app.findMinArrowShots(new int[][] {{1,2}, {2,3}, {3,4}, {4,5}}));
    }
}
