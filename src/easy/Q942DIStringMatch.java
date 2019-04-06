package easy;

public class Q942DIStringMatch {
    // O(2n) -> O(n)
    // will work, but can be reduced to loop through just once
    public int[] diStringMatchOld(String S) {
        int[] result = new int[S.length() + 1];

        int startPlus = S.length() - 1;
        int startMinux = S.length() + 1;
        int minValue = startMinux;
        result[0] = S.length();

        for(int i = 1; i < S.length(); i++) {

        }

        // another loop reduce all val by min

        return result;
    }

    public int[] diStringMatch(String S) {
        int[] result = new int[S.length() + 1];
        int max = S.length();
        int min = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'D') {
                result[i] = max--;
            } else if (S.charAt(i) == 'I') {
                result[i] = min++;
            }
        }

        result[S.length()] = min;

        return result;
    }
}
