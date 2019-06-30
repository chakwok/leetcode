package medium;

import java.util.Arrays;

public class Q1100FindK_LengthSubstringsWithNoRepeatedCharacters {
    public static void main(String[] args) {
        System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
        System.out.println(numKLenSubstrNoRepeats("home", 5));
    }

    public static int numKLenSubstrNoRepeats(String S, int K) {
        if(K > S.length()) {
            return 0;
        }

        char[] chs = S.toCharArray();
        int[] set = new int[26];
        for(int i = 0; i < set.length; i++ ) {
            set[i] = -1;
        }
        int result = 0;

        label: for(int i = 0; i < S.length() - K + 1; i++) {
            for(int j = i; j < i + K; j++) {
                if(set[chs[j] - 'a'] != i ) {
                    set[chs[j] - 'a'] = i;
                } else {
                    break;
                }

                if(j == i + K - 1) {
                    result ++;
                }
            }
        }

        return result;

    }
}
