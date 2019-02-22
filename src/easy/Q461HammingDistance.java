package easy;

public class Q461HammingDistance {
    public int hammingDistance(int x, int y) {
        int bitDiff = x ^ y;
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += (bitDiff & 1);;
            bitDiff = bitDiff >> 1;
        }
        return count;
    }
}
