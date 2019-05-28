package easy;

import java.util.*;

public class Q500KeyboardRow {
    public String[] findWords(String[] words) {
        HashSet<Character> qwer = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't','y','u','i','o','p'));
        HashSet<Character> asdf = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        HashSet<Character> zxcv = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));

        List<String> list = new LinkedList<>();
        for(String word: words) {
            if(containsOnlyThisRow(word, qwer) || containsOnlyThisRow(word, asdf) || containsOnlyThisRow(word, zxcv)) {
                list.add(word);
            }
        }

        String[] array = list.toArray(new String[0]);

        return array;
    }

    private boolean containsOnlyThisRow(String word, HashSet<Character> set) {
        for(char ch: word.toCharArray()) {
            if(!set.contains(ch) && !set.contains(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }
}
