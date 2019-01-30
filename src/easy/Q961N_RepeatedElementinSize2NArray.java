package easy;

public class Q961N_RepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        try {
            for (int i = 0; i < A.length; i++) {
                for(int j = i + 1; j <= i + 2 && j < A.length ;j++) {
                    if(A[i] == A[j]) {
                        return A[i];
                    }
                }
            }
            return A[A.length - 1];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return -37;
        }
    }

    public static void main(String[] args) {
        Q961N_RepeatedElementinSize2NArray helper = new Q961N_RepeatedElementinSize2NArray();
        int ans  = helper.repeatedNTimes(new int[]{9,5,9,6});
        System.out.println(ans);
    }
}
