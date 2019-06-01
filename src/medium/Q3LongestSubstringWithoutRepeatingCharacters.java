package medium;

import java.util.HashSet;

public class Q3LongestSubstringWithoutRepeatingCharacters {
    // O(2n) 9ms
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int max = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    // 55ms O(n^2)
    public int lengthOfLongestSubstringOld(String s) {
        HashSet<Character> set = new HashSet<>();
        if(s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + max> chars.length + 1 ) {
                break;
            }
            for(int j = i; j < s.length(); j++) {
                if(!set.contains(chars[j])) {
                    set.add(chars[j]);
                } else {
                    max = Math.max(set.size(), max);
                    set.clear();
                    break;
                }
            }

        }

        if(set.size() != 0) {
            max = Math.max(set.size(), max);
            set.clear();
        }

        return max;
    }
}
