package easy;

public class Q868BinaryGap {
    public int binaryGap(int N) {
        int longest = 0;

        if (N == 0) {
            return 0;
        }

        //get the first one in the series
        while (N%2 != 1) {
            N /= 2;
            /* not necessary as there must be at least one 1's
            if (N == 0) {
                return 0;
            }*/

        }
        N /= 2;

        int dist = 0;
        //traversing the binary representation
        while (N != 0) {
            if (N % 2 == 1) {
                longest = Math.max(longest, dist + 1);
                dist = 0;
            } else {
                dist++;
            }
            N /= 2;
        }

        return longest;
    }

}
