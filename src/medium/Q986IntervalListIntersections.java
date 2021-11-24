package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q986IntervalListIntersections {
    public int[][] intervalIntersectionBetter(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new LinkedList<>();
        if(firstList.length == 0 || secondList.length == 0) {
            return ans.toArray(new int[0][0]);
        }

        int firstPos = 0;
        int secondPos = 0;

        while(true) {
            int[] firstRange = firstList[firstPos];
            int[] secondRange = secondList[secondPos];

            int[] smaller;
            int[] other;
            if(firstRange[0] < secondRange[0]) {
                smaller = firstRange;
                other = secondRange;
            } else {
                smaller = secondRange;
                other = firstRange;
            }

            if(other[0] <= smaller[1]) {
                int min = Math.min(smaller[1], other[1]);
                ans.add(new int[] {other[0], min});
            }

            if(firstPos + 1 >= firstList.length && secondPos + 1 >= secondList.length) {
                return ans.toArray(new int[0][0]);
            } else if(firstPos + 1 >= firstList.length) {
                secondPos++;
            } else if(secondPos + 1 >= secondList.length) {
                firstPos++;
            } else {
                firstRange = firstList[firstPos + 1];
                secondRange = secondList[secondPos + 1];
                if(firstRange[0] > secondRange[0]) {
                    secondPos++;
                } else {
                    firstPos++;
                }
            }
        }
    }
}
