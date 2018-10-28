package Easy;

public class Q278FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mi;

        while (lo != hi) {
            mi = lo + (hi - lo) / 2;

            if (isBadVersion(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
