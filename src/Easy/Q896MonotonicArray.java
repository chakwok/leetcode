package Easy;

public class Q896MonotonicArray {
    public static boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }

        int front = 0;
        int end = A.length - 1;

        while (A[front] == A[front + 1]) {
            front++;
            if(front == end) {
                return true;
            }
        }

        int isIncreasing = Integer.compare(A[front + 1], A[front]);
        front++;

        for (int i = front; i < end; i++) {
            if (Integer.compare(A[i + 1], A[i]) == -isIncreasing) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {1,2 ,2, 3}));
        System.out.println(isMonotonic(new int[] {6, 5, 4, 4}));
        System.out.println(isMonotonic(new int[] {1, 3, 2}));
        System.out.println(isMonotonic(new int[] {1, 2, 4, 5}));
        System.out.println(isMonotonic(new int[] {1, 1, 1}));
        System.out.println(isMonotonic(new int[] {5, 3, 2, 4, 1}));
    }

}
