package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q824GoatLatin {
    //7ms
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet();
        for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            vowel.add(c);

        int t = 1;
        StringBuilder ans = new StringBuilder();
        for (String word: S.split(" ")) {
            char first = word.charAt(0);
            if (vowel.contains(first)) {
                ans.append(word);
            } else {
                ans.append(word.substring(1));
                ans.append(word.substring(0, 1));
            }
            ans.append("ma");
            for (int i = 0; i < t; i++)
                ans.append("a");
            t++;
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    //14ms
    public String toGoatLatinOld(String S) {
        HashSet<Character> vowels = new HashSet<>(10);
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


        String[] words = S.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].charAt(0))) {
                builder.append(words[i]);
                builder.append("ma");
                //leetcode doesn't support java 11
                //builder.append("a".repeat(i));
                builder.append(new String(new char[i + 1]).replaceAll("\0", "a"));

            } else {
                builder.append(words[i].substring(1));
                builder.append(words[i].charAt(0));
                builder.append("ma");
                //builder.append("a".repeat(i));
                builder.append(new String(new char[i + 1]).replaceAll("\0", "a"));
            }
            builder.append(" ");
        }

        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
