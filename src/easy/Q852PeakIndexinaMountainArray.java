package easy;

public class Q852PeakIndexinaMountainArray {
    public static int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (A[middle] < A[middle + 1]) {
                low = middle + 1; // to avoid infinite loop; since we know that middle + 1 is still
                                  // increasing so we can just search from middle + 1 instead of
                                  // from middle
            } else {
                high = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int ans = peakIndexInMountainArray(new int[] {1, 2, 3, 4, 1});
        System.out.println(ans);
    }
}
