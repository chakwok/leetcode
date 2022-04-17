package contest.weekly;

import java.util.*;

public class Contest289 {
    public static void main(String[] args) {
        var app = new Contest289();
//        System.out.println(app.digitSum("11111222223", 3));
//        System.out.println(app.digitSum("00000000", 3));
//        System.out.println(app.digitSum("1234", 2));
//        System.out.println(app.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
//        System.out.println(app.minimumRounds(new int[]{2,2,3}));
//        System.out.println(app.minimumRounds(new int[]{5,5,5,5}));
        System.out.println(app.longestPath(new int[]{ -1,0,0,1,1,2},"abacbe"));
    }
    public int longestPath(int[] parent, String s) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < parent.length; i++) {
            List<Integer> lst = map.getOrDefault(parent[i], new ArrayList<>());
            lst.add(i);
            map.put(parent[i], lst);
        }
//        set.add(s.charAt(0));
        return longestPath(map, s, 0, set).size();
    }

    public HashSet<Character> longestPath(HashMap<Integer, List<Integer>> map, String s, int idx, HashSet<Character> visited) {
        return visited;
    }

//    public int longestPath(int[] parent, String s) {}


    /*public HashSet<Character> longestPath(int[] parent, String s, int prev, int to, HashSet<Character> visited) {
        if(to != prev + 1) {
            return visited;
        }
        Character curr = s.charAt(to);
        if(visited.contains(curr)) {
            return visited;
        }

        visited.add(s.charAt(prev));

        HashSet<Character> setL = new HashSet<>(visited);
        HashSet<Character> setR = new HashSet<>(visited);

        int l = longestPath(parent, s, to, )
    }*/

    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder next = new StringBuilder();


        while(sb.length() > k) {
            int i = 0;
            while (i < sb.length()) {
                int sum = 0;
                int tmp = i + k;
                for (int j = i; j < tmp && j < sb.length(); j++) {
                    sum += sb.charAt(j) - '0';

                    i++;
                }
                next.append(Integer.toString(sum));
            }

            sb = next;
            next = new StringBuilder();
        }

        return sb.toString();
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int task : tasks) {
            int count = 1 + map.getOrDefault(task, 0);
            map.put(task, count);
        }

        int out = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value == 1) {
                return -1;
            } else if(value % 3 == 0) {
                out += value / 3;
            } else {
                out += value / 3 + 1;
            }
        }
        return out;
    }
}
