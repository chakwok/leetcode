package medium;

import java.util.*;

public class Q1094CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> {
            return t1[1] - t2[1];
        });

        int total = 0;
        ArrayList<int[]> lst = new ArrayList<>();
        for(int i = 0; i < trips.length; i++) {
            int newStart = trips[i][1];

            lst.add(trips[i]);
            total += trips[i][0];

            Iterator<int[]> iter =  lst.iterator();
            while(iter.hasNext() ) {
                int[] trip = iter.next();
                if(trip[2] <= newStart) {
                    total -= trip[0];
                    iter.remove();

                }
            }
            /*for(int j = 0; j < lst.size(); j++) {
                if(lst.get(j)[2] <= newStart) {
                    total -= lst.get(j)[0];
                    lst.remove(j);

                }
            }*/

            if(total > capacity) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        boolean ans = carPooling(new int[][]{{2,1,5}, {3,3,7}}, 4);

        System.out.println(ans);
        ans = carPooling(new int[][]{{2,1,5}, {3,3,7}}, 5);
        System.out.println(ans);

        ans = carPooling(new int[][]{{2,1,5}, {3,5,7}}, 3);
        System.out.println(ans);

        ans = carPooling(new int[][]{{3,2,7},{3,7,9},{8,3,9}}, 11);
        ans = carPooling(new int[][]{{3,2,8},{4,4,6},{10,8,9}}, 11);
        System.out.println(ans);
    }


}
