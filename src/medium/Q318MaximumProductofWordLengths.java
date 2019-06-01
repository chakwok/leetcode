package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;

public class Q318MaximumProductofWordLengths {
    public static int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0 ;
        }


        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
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
