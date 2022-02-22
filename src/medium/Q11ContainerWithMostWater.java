package medium;

import java.util.LinkedList;
import java.util.List;

public class Q11ContainerWithMostWater {
    public static void main(String[] args) {
        var app = new Q11ContainerWithMostWater();
        System.out.println(app.maxArea(new int[] {2,3,4,5,18,17,6}));
        System.out.println(app.maxArea(new int[] {1,2,4,3}));
        System.out.println(app.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int h = 0 ;
        int t = height.length - 1;

        while(h < t) {
            int curr = (t - h) * Math.min(height[h], height[t]);
            max = Math.max(max, curr);

            if(height[t] == height[h]) {
                h++;
                t--;
            } else if(height[t] > height[h]) {
                h++;
            } else {
                t--;
            }
        }
        return max;
    }

    //worst case O(n^2), good case O(n)
    public int maxAreaSlow(int[] height) {
        if(height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        left.add(0);
        right.add(height.length - 1);

        for(int i = 1; i < height.length - 1; i++) {
            if(height[i] > maxLeft) {
                left.add(i);
                maxLeft = height[i];
            }
        }

        for(int i = height.length - 1; i > 0; i--) {
            if(height[i] > maxRight) {
                right.add(i);
                maxRight = height[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int l : left) {
            for(int r : right) {
                int curr = Math.min(height[l], height[r]) * (r - l);
                max = Math.max(max, curr);
            }
        }

        return max;
    }
}
