package Medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Q56MergeIntervals {


    //TODO: Doesn't work when [1, 4], [2, 3]. should probably redo
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.size(), (Interval a, Interval b) -> a.start - b.start);

        for(Interval ele: intervals) {
            pq.offer(ele);
        }
        LinkedList<Interval> list = new LinkedList<>(pq);
        Iterator<Interval> iter = list.iterator();
        Interval prev = iter.next();
        int prevEnd = prev.end;

        Interval curr;
        while(iter.hasNext()) {
            curr = iter.next();
            if (prevEnd > curr.start) {
                prev.end = curr.end;
                iter.remove();
            } else {
                prev = curr;
            }

        }
        return list;
    }



    //only works if the list is already sorted according to its start time
    public static List<Interval> merge2(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }


        Iterator<Interval> iter = intervals.iterator();
        Interval prev = iter.next();
        int prevEnd = prev.end;

        Interval curr;
        while(iter.hasNext()) {
            curr = iter.next();
            if (prevEnd >= curr.start) {
                prev.end = curr.end;
                iter.remove();
            } else {
                prev = curr;
            }

        }

        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> lst = new LinkedList<>();
        lst.add(new Interval(2,4));
        lst.add(new Interval(1,3));
        lst.add(new Interval(2,5));
        lst.add(new Interval(8, 10));
        //= List.of(new Interval(1,3), new Interval(2, 6), new Interval(8, 10));
        System.out.println(merge(lst));
    }


    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return String.format("[%d, %d]", start, end);
        }
    }

}
