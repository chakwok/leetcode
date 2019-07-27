package easy;

public class Q5028ArmstrongNumber {
    public static boolean isArmstrong(int N) {
        if (N == 0) {
            return false;
        }

        int check = N;

        int digit = 0;
        while(N > 0 ) {
            N /= 10;
            digit++;
        }

        int sum = 0;



        N = check;
        while(N > 0) {
            sum += Math.pow(N%10, digit);
            N /= 10;
        }

        return check == sum;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(123));
    }
}
