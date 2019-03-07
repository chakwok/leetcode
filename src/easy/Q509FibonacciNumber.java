package easy;

public class Q509FibonacciNumber {
    public static int fib(int N) {
        if(N == 0 || N == 1) {
            return N;
        }
        int prev = 0;
        int curr = 1;
        int temp;
        for(int i = 1; i < N; i++) {
            temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
