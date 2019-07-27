package easy;

public class Q5034LargestUniqueNumber {
    public static int largestUniqueNumber(int[] A) {
        int[] arr = new int[1001];

        for(int i = 0; i < A.length; i++) {
            arr[A[i]] += 1;
        }

        for(int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[i] == 1) {
                return i;
            }
        };

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(largestUniqueNumber(new int[]{ 8,8,9,9}));
        System.out.println(largestUniqueNumber(new int[]{ 5,7,3,9,4,9,8,3,1}));
    }
}
