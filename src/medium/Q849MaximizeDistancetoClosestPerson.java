package medium;

import java.util.Arrays;

public class Q849MaximizeDistancetoClosestPerson {
    public static void main(String[] args) {
        var app = new Q849MaximizeDistancetoClosestPerson();
        System.out.println(app.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(app.maxDistToClosest(new int[]{1,0,0,0}));
    }
    public int maxDistToClosest(int[] seats) {
        int max = 1;

        int first = -1;
        int last = -1;

        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                first = i;
                break;
            }
        }
        max = Math.max(max, first);

        for(int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 1) {
                last = i;
                break;
            }
        }
        max = Math.max(seats.length - 1 - last, max);

        int disMax = 0;
        int d = 0;
        for(int i = first; i <= last; i++) {
            if(seats[i] == 1) {
                disMax = Math.max(disMax, d);
                d = 0;
            } else {
                d++;
            }
        }
        max = Math.max(max, (disMax + 1)/2 );

        return max;
    }
}
