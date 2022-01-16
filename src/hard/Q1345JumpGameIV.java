package hard;

import java.util.*;

public class Q1345JumpGameIV {
    public static void main(String[] args) {
        var app = new Q1345JumpGameIV();
        System.out.println(app.minJumps(new int[] {7,11,11,11,11,11,11,11}));

        System.out.println(app.minJumps(new int[] {7,6,9,6,9,6,9,7}));
        System.out.println(app.minJumps(new int[] {100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(app.minJumps(new int[] {7}));
    }

    public int minJumps(int[] arr) {
        if(arr.length == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            List<Integer> lst = map.getOrDefault(num, new LinkedList<>());
            lst.add(i);
            map.put(num, lst);
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {dp.length - 1, 0}); // idx, cost

        Set<Integer> visitedValue = new HashSet<>();

        while(q.size() > 0) {
            int[] curr = q.pop();
            int idx = curr[0];
            int cost = curr[1];
            if(idx == 0) {
                return cost;
            }

            if(dp[idx] < 0) {
                dp[idx] = cost;

                List<Integer> sames = map.get(arr[idx]);
                int prev = idx - 1;
                if(prev >= 0 &&  dp[prev] == -1) {
                    q.add(new int[] {prev, cost + 1});
                    dp[prev] = -2;
                }

                int next = idx + 1;
                if (next < dp.length && dp[next] == -1) {
                    q.add(new int[] {next, cost + 1});
                    dp[next] = -2;
                }


                if(!visitedValue.contains(arr[idx])) {
                    for(int same : sames) {
                        if(same >= 0 && same <= dp.length && dp[same] == -1) {
                            q.add(new int[] {same, cost + 1});
                            dp[same] = -2;
                        }
                    }
                }
                visitedValue.add(arr[idx]);
            }
        }

        return -1;
    }

    /*private int minJumps(int[] arr, Map<Integer, List<Integer>> map, int[] dp, int idx, int cost) {
        if(idx < 0 || idx >= dp.length) {
            return -1;
        }
        if(dp[idx] != -1) {
            dp[idx] = cost;

            List<Integer> nexts = map.get(arr[idx]);
            minJumps(arr, map, dp, idx + 1, cost + 1);
            minJumps(arr, map, dp, idx - 1, cost + 1);
            for(int next : nexts) {
                minJumps(arr, map, dp, next, cost + 1);
            }
        }


    }*/
}
