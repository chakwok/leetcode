package easy;

public class Q191Numberof1Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = hammingWeight(11);
        System.out.println(ans);
    }
}
