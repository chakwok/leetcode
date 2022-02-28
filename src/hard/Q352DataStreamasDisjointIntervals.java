package hard;

import java.util.*;

public class Q352DataStreamasDisjointIntervals {
    class SummaryRanges {
        TreeSet<int[]> ts;
        Set<Integer> unsettled;

        int[][] cached;

        public SummaryRanges() {
            ts = new TreeSet<>(Comparator.comparingInt(it -> it[0]));
            unsettled = new LinkedHashSet<>();
            cached = null;
        }

        public void addNum(int val) {
            cached = null;
            unsettled.add(val);
        }

        public int[][] getIntervals() {
            if(cached != null) {
                return cached;
            } else {
                return settleAndReturn();
            }
        }

        private int[][] settleAndReturn() {
            for(int curr: unsettled) {
                settleOne(curr);
            }
            return ts.toArray(new int[][]{});
        }

        private void settleOne(int val) {
            int[] curr = new int[] {val, val};
            int[] floor = ts.floor(curr);
            if(floor == null) {
                ts.add(curr);
            } else {
                if(val >= floor[0] && val <= floor[1]) {
                    return;
                } else {
                    if(val == floor[1] + 1) {
                        floor[1] += 1;
                        curr= floor;
                    } else {
                        ts.add(curr);
                    }
                }
            }

            int[] next = ts.higher(curr);
            if(next != null) {
                if(next[0] == curr[1] + 1) {
                    ts.remove(next);
                    curr[1] = next[1];
                }
            }
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
}
