package easy;

public class Q686RepeatedStringMatch {
    //A: "abcd"
    //B: "cdabcdab"

    public static int repeatedStringMatch(String A, String B) {
        int repeated = 1;

        outer: for (int i = 0; i < A.length(); i ++) {
            int aIndex = i;
            repeated = 1;
            for (int j = 0; j < B.length(); j++) {
                if (B.charAt(j) != A.charAt(aIndex)) {
                    continue outer;
                }

                if (j == B.length() - 1) {
                    return repeated;
                }

                if (aIndex == A.length() - 1) {
                    aIndex = 0;
                    repeated += 1;
                } else {
                    aIndex ++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int ans = repeatedStringMatch("abcd",
                "abcdb");
        System.out.println(ans);
    }
}
