package medium;

import java.util.*;

public class Q347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            result.add(entries.get(i).getKey());
        }

        return result;
    }


    public List<Integer> topKFrequentNoLambda(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            result.add(entries.get(i).getKey());
        }

        return result;
    }
}
