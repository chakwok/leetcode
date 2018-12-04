package Medium;

import java.util.TreeMap;

public class Q729MyCalendarI {
    TreeMap<Integer, Integer> calendar;

    public Q729MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = calendar.lowerKey(end);

        if(low == null || calendar.get(low) <= start) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

/*    public boolean book(int start, int end) {
        Integer prevStart = calendar.floorKey(start);
        Integer nextStart = calendar.ceilingKey(start);

        if ((prevStart == null ||start >= calendar.get(prevStart)) && (nextStart == null || end <= nextStart)) {
            calendar.put(start,end);
            return true;
        }

        return false;
    }*/
}
