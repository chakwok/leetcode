package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253MeetingRoomsII {
    public static void main(String[] args) {
        var app = new Q253MeetingRoomsII();
        System.out.println(app.minMeetingRooms(new int[][] {{0,30}, {5,10}, {15,20}}));
        System.out.println(app.minMeetingRooms(new int[][] {{7,10}, {2,4}}));
        System.out.println(app.minMeetingRooms(new int[][] {{7,10}}));
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        PriorityQueue<Integer> ongoing = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for(int[] interval: intervals) {
            int start = interval[0];

            while(ongoing.size() > 0) {
                int lastEnd = ongoing.peek();
                if(start >= lastEnd) {
                    ongoing.poll();
                } else {
                    break;
                }
            }

            ongoing.add(interval[1]);
            max = Math.max(max, ongoing.size());
        }

        return max;
    }
}
