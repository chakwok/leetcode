package easy;

public class Q476NumberComplement {
    public int findComplement(int num) {
        int X = 1;
        while (num > X) X = X * 2 + 1;
        return X - num;

    }
}
