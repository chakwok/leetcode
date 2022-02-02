package easy;

public class Q941ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }

        if(arr[1] <= arr[0]) return false;

        boolean up = true;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if(curr == prev) {
                return false;
            }

            if(up) {
                if(curr < prev) {
                    up = false;
                }
            } else {
                if(prev < curr) {
                    return false;
                }
            }
            prev = curr;
        }
        if(up) return false;
        return true;
    }
}
