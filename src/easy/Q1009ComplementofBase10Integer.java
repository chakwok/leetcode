package easy;

public class Q1009ComplementofBase10Integer {
    public static int bitwiseComplement(int N) {
        //101 => 010; 101 + 010 = 111
                // 111
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;

    }

    public static void main(String[] args) {
        int ans = bitwiseComplement(5);
        System.out.println(ans);
    }
}
