package easy;

public class Q985SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        A[queries[0][1]] += queries[0][0];
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i]%2 == 0) {
                sum += A[i];
            }

        }
        result[0] = sum;

        for(int i = 1; i < queries.length; i++) {
            int idx =queries[i][1];
            if(A[idx]%2 == 0) {
                sum -= A[idx];
            }
            A[idx] += queries[i][0];
            if(A[queries[i][1]]%2 ==0) {
                sum += A[idx];
            }


            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        Q985SumofEvenNumbersAfterQueries app = new Q985SumofEvenNumbersAfterQueries();
        app.sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0}, {-3, 1}, {-4, 0}, {2,3}});
    }
}
