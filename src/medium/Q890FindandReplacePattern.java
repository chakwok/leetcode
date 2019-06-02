package medium;

import java.util.*;

public class Q890FindandReplacePattern {
    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "mee"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList<String>();

        pattern = transform(pattern);
        for(String word: words) {
            if(pattern.equals(transform(word))) {
                result.add(word);
            }
        }

        return result;
    }

    //no destructive as it can't be, string is immutable
    private static String transform(String in) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char letter = 'a';

        for(int i = 0; i < in.length(); i++) {
            if(!map.containsKey(in.charAt(i))) {
                sb.append(letter);
                map.put(in.charAt(i), letter++);
            } else {
                sb.append(map.get(in.charAt(i)));
            }
        }

        return sb.toString();
    }
}
