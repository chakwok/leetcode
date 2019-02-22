package hard;

public class Q975OddEvenJump {
    public static void main(String[] args) {
        Q975OddEvenJump app = new Q975OddEvenJump();
         int ans = app.oddEvenJumps(new int[] {10,13,12,14,15});
        System.out.println(ans);
    }

    private enum JumpSuccesses {
        UNCERTAIN,
        ODDSUCCESS,
        ODDFAILURE,
        EVENSUCCESS,
        EVENFAILURE;
    }

    private int[] JumpsSuccess;
    int successCount;


    public int oddEvenJumps(int[] A) {
        JumpsSuccess = new int[A.length];

        successCount = 0;

        for(int i = A.length - 1; i >= 0; i--) {
            jumpOdd(A, i);
        }

        return successCount;
    }

    private boolean jumpOdd(int[] A, int index) {
        if(index == A.length - 1 || JumpsSuccess[index] == 1) {
            successCount++;
            JumpsSuccess[index] = 1;
            return true;
        } else if(JumpsSuccess[index] == 2) {
            return false;
        }

        int smallest = Integer.MAX_VALUE;
        int smallestIndex = Integer.MAX_VALUE;

        for(int i = index + 1; i < A.length; i++) {
            if(A[i] >= A[index] && A[i] < smallest) {
                smallest = A[i];
                smallestIndex = i;
            }
        }

        if(smallestIndex == A.length - 1) {
            JumpsSuccess[index] = 1;
            successCount++;
            return true;
        } else if(smallestIndex == Integer.MAX_VALUE) {
            JumpsSuccess[index] = 2;
            return false;
        } else {
            return jumpEven(A, smallestIndex);
        }
    }

    private boolean jumpEven(int[] A, int index) {
        if(index == A.length - 1 || JumpsSuccess[index] == 3) {
            successCount++;
            JumpsSuccess[index] = 3;
            return true;
        } else if(JumpsSuccess[index] == 4) {
            return false;
        }

        int largest = Integer.MIN_VALUE;
        int largestIndex = Integer.MIN_VALUE;

        for(int i = index + 1; i < A.length; i++) {
            if(A[i] <= A[index] && A[i] > largest) {
                largest = A[i];
                largestIndex = i;
            }
        }

        if(largestIndex == A.length - 1) {
            JumpsSuccess[index] = 3;
            successCount++;
            return true;
        } else if(largestIndex == Integer.MIN_VALUE) {
            JumpsSuccess[index] = 4;
            return false;
        } else {
            return jumpOdd(A, largestIndex);
        }
    }
}
