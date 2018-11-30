package Easy;

import java.util.HashSet;
import java.util.Set;

public class Q859BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        char diffA = '\0';
        char diffB = '\0';
        boolean foundBothDiff = false;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                //first difference
                if (diffA == '\0') {
                    diffA = A.charAt(i);
                    diffB = B.charAt(i);
                //second Difference
                } else if (!foundBothDiff) {
                    if (diffA == B.charAt(i) && diffB == A.charAt(i)) {
                        foundBothDiff = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }


        if (foundBothDiff) {
            //there is one swappable difference in String A, B
            return true;
        } else {
            //check for any duplicated string; return true if exists
            Set<Character> set = new HashSet<>(A.length());
            for (int i = 0; i < A.length(); i++) {
                if (set.contains(A.charAt(i))) {
                    return true;
                } else {
                    set.add(A.charAt(i));
                }
            }

            return false;
        }
    }
}
