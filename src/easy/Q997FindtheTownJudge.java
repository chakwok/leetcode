package easy;

import java.util.Arrays;

public class Q997FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        boolean[] trustedSomeone = new boolean[n + 1];
        for(int[] t : trust) {
            trustedSomeone[t[0]] = true;
        }

        int potentialJudge = -1;
        for(int i = 1; i < trustedSomeone.length; i++) {
            if(!trustedSomeone[i]) {
                if(potentialJudge == -1) {
                    potentialJudge = i;
                } else {
                    return -1;
                }
            }
        }

        Arrays.fill(trustedSomeone, false);

        for(int[] t : trust) {
            if(t[1] == potentialJudge) {
                trustedSomeone[t[0]] = true;
            }
        }

        for(int i = 1; i < trustedSomeone.length; i++) {
            if(i == potentialJudge) {
                continue;
            }

            if(!trustedSomeone[i]) {
                return -1;
            }
        }

        return potentialJudge;
    }
}
