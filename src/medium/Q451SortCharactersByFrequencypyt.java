package medium;

import java.util.*;
import java.util.stream.Collectors;

public class Q451SortCharactersByFrequencypyt {
    public String frequencySortElegant(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        StringBuilder res = new StringBuilder();

        for(char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        for(Map.Entry<Character, Integer> map2 : list) {
            char ch = map2.getKey();
            int freq = map2.getValue();
            while(freq-- > 0)
                res.append(ch);
        }
        return res.toString();
    }


    public static String frequencySort(String s) {
        //since input char is not specified, can't have an array of custom length to count. char can have 16bits max
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        //construct a reverse map from Integer to a List of Character that has that count
        //e.g. 1 -> asList('A'), 2-> asList('a', 'b'). That means s.length = 5, A*1 a*2 b*2
        TreeMap<Integer, List<Character>> reverseMap = new TreeMap<>(Collections.reverseOrder());
        for(Character ch: map.keySet()) {
            if(!reverseMap.containsKey(map.get(ch))) {
                List<Character> lst = new LinkedList<>();
                lst.add(ch);
                reverseMap.put(map.get(ch), lst);
            } else {
                List<Character> lst = reverseMap.get(map.get(ch));
                lst.add(ch);
                reverseMap.put(map.get(ch),  lst);
            }
        }

        //using the reverseMap to construct back the new String
        StringBuilder sb =  new StringBuilder();
        for(Map.Entry<Integer,  List<Character>> entry: reverseMap.entrySet()) {
            for(Character ch: entry.getValue()) {
                for(int i = 0; i < entry.getKey(); i++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static String frequencySortNotWork(String s) {
        //since input char is not specified, can't have a custom map to count
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // char of same length may mess up  aabb vs abab(not what we want.
        String result = s.chars().mapToObj(c -> (char) c).sorted((c1, c2) -> map.get(c2) - map.get(c1)).map(String::valueOf).collect(Collectors.joining());

        return result;
    }



    public static void main(String[] args) {
        System.out.println(frequencySort("aabbA"));
    }
}
