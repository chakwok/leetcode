package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;

public class Q318MaximumProductofWordLengths {
    //4ms
    public static int maxProductBetter(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }

    //80ms. O(nm + n^2)
    public static int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0 ;
        }


        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });

        HashSet<Character>[] arr = (HashSet<Character>[]) new HashSet[words.length];
        int count = 0;
        for(String word: words) {
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
            arr[count++] = set;
        }

        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(!containsDuplicate(arr[i], arr[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                    break;
                }
            }
        }

        return max;
    }

    static <T> boolean containsDuplicate(HashSet<T> s1, HashSet<T> s2) {
        for(T ele: s1) {
            if(s2.contains(ele)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
    }
}
