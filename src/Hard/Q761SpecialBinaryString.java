package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q761SpecialBinaryString {
    // wrong, the problem is recursive in nature. While what it does inside a loop seems correct,
    // the recursive nature of the problem is not solved.
    public static String makeLargestSpecialTry(String S) {
        int oneCount = 0;
        int zeroCount = 0;
        int frontOne = 0;
        List<String> specialSubstrings = new ArrayList<>();
        S = S + '0';

        int startPos = -1; // the starting position of a fresh one (one that at the beginning or after a zero)
        for (int i = 0; i < S.length(); i++) {
            if (startPos == -1) {
                startPos = i;
            }

            if (zeroCount == 0 && S.charAt(i) == '1') {
                oneCount++;
            } else if (zeroCount != 0 && oneCount == zeroCount) {
                specialSubstrings.add(S.substring(startPos, i));
                //reset all the count
                zeroCount = 0;
                oneCount = 0;

                //start again in the fresh 1's
                startPos = -1;
                i--;

            } else if (S.charAt(i) == '0') {
                zeroCount++;
            } else {
                //so it must be zeroCount != 0 && S.CharAt(i) == '1'
                int excessOne = oneCount - zeroCount;
                frontOne += excessOne;

                specialSubstrings.add(S.substring(startPos + excessOne , i));

                //reset all the count
                zeroCount = 0;
                oneCount = 0;

                //start again in the fresh 1's
                startPos = -1;
                i--;
            }
        }
        Collections.sort(specialSubstrings, Collections.reverseOrder());
        return S.substring(0, frontOne) + String.join("", specialSubstrings) +  S.substring(S.length() - frontOne);
    }

    public static String makeLargestSpecial(String S) {
        //implicit base case is when S is an empty String, where i == j
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1') count++;
            else count--;

            //this case would occur whenever
            // 1. it reach the end(found an instance of 1...0 where 1 is the first character and 0 is the last character
            // 2. found an substring (inside that whole String) that has 1..0
            if (count == 0) {
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        // case 1: there can only be one string in res, we can just output it
        // case 2: sort the substrings in reserve order so string with more 1's will be at front.
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

    public static void main(String[] args) {
        String ans = makeLargestSpecial("110110100100");
        System.out.println(ans);
    }
}
