package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

    public class Q1306JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }

    //non destructive
    public boolean canReachND(int[] arr, int start) {
        if(start < 0 || start >= arr.length) {
            return false;
        }

        Set<Integer> reached = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList();

        q.offer(start);
        while(q.size() > 0) {
            int currIdx = q.poll();
            int curr = arr[currIdx];
            if(curr == 0) {
                return true;
            }

            reached.add(currIdx);

            int front = currIdx - curr;
            if((front >= 0 && front < arr.length) && !reached.contains(front)) {
                q.offer(front);
            }
            int back = currIdx + curr;
            if((back >= 0 && back < arr.length) && !reached.contains(back)) {
                q.offer(back);
            }
        }

        return false;
    }
}
