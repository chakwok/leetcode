package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q290WordPattern {
    public static void main(String[] args) {
        var app = new Q290WordPattern();
        System.out.println(app.wordPattern("abba", "dog cat cat dog"));
        System.out.println(app.wordPattern("abba", "dog cat cat fish"));
        System.out.println(app.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(app.wordPattern("abbc", "dog cat cat fish"));
        System.out.println(app.wordPattern("abba", "dog dog dog dog"));

    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if(arr.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>(26);
        Set<String> registered  = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
            char symbol = pattern.charAt(i);
            String word = arr[i];

            if(!map.containsKey(symbol)) {
                if(registered.contains(word)) {
                    return false;
                }
                map.put(symbol, word);
                registered.add(word);
            } else {
                String used = map.get(symbol);
                if(!used.equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }
}
