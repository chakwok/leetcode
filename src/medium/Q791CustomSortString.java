package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q791CustomSortString {
    public String customSortStringSol(String S, String T) {
        int[] bucket = new int[26];
        for (char c : T.toCharArray()) {
            bucket[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            for (int i = 0; i < bucket[c - 'a']; i++) {
                sb.append(c);
            }
            bucket[c - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }

        return sb.toString();
    }


    public static String customSortString(String S, String T) {
        int[] priorityAtZ = new int[26];
        int priority = 1;

        for(int i = 0; i < S.length(); i++) {
            priorityAtZ[(int)(S.charAt(i) - 'a')] = priority++;
        }

        //put everything with 0 priority at the beginning
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < T.length(); i++) {
            int priVal = (int) (T.charAt(i) - 'a');
            if(priorityAtZ[priVal] == 0) {
                builder.insert(0, T.charAt(i));
            }
        }

        for(int i = 1; i <= priority; i++) {
            for(int j = 0; j < T.length(); j++) {
                int priVal = (int) (T.charAt(j) - 'a');
                if(priorityAtZ[priVal] == i) {
                    builder.append(T.charAt(j));
                }
            }
        }


        return builder.toString();
    }

    //45ms beating 5.38% submission
    public static String customSortStringOld(String S, String T) {
        int[] priorityAtZ = new int[26];
        int priority = 1;
        for(int i = 0; i < S.length(); i++) {
            priorityAtZ[(int)(S.charAt(i) - 'a')] = priority++;
        }
        List<Character> lst = T.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
        lst.sort(Comparator.comparing(x -> priorityAtZ[x - 'a']));
        StringBuilder result = new StringBuilder();
        lst.forEach(x -> result.append(x));

        return result.toString();
    }

    public static void main(String[] args) {
        String ans = customSortString("cba", "abcd");
        System.out.println(ans);
    }
}
