package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q438FindAllAnagramsinaString {
    public static void main(String[] args) {
        var app = new Q438FindAllAnagramsinaString();
        System.out.println(app.findAnagrams("cbaebabacd", "abc"));
        System.out.println(app.findAnagrams("abab", "ab"));
        System.out.println(app.findAnagrams("ab", "ab"));
        System.out.println(app.findAnagrams("cabab", "ab"));
        System.out.println(app.findAnagrams("c", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) {
            return Collections.emptyList();
        }

        int[] moving = new int[26];
        int[] fixed = new int[26];

        int n = s.length();
        int l = p.length();

        for(int i = 0; i < l; i++) {
            int idxMoving = s.charAt(i) - 'a';
            int idxFixed = p.charAt(i) - 'a';
            moving[idxMoving]++;
            fixed[idxFixed]++;
        }
        LinkedList<Integer> out = new LinkedList<>();

        if(Arrays.equals(moving, fixed)) {
            out.add(0);
        }

        for(int i = 1; i <= n - l ; i++) {
            moving[s.charAt(i - 1) - 'a']--;
            moving[s.charAt(i + l - 1) - 'a']++;
            if(Arrays.equals(moving, fixed)) {
                out.add(i);
            }
        }

        return out;
    }
}
