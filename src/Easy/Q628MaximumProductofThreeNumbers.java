package Easy;

import java.util.Arrays;

public class Q628MaximumProductofThreeNumbers {
    public static int maximumProduct(int[] nums) {
        int[] bigThree = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] smallTwo = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int temp;
        for(int num: nums) {
            for (int i = 0; i < bigThree.length; i++) {
                if (num > bigThree[i]) {
                    temp = bigThree[i];
                    bigThree[i] = num;
                    num = temp;
                }
            }
        }

        for(int num: nums) {
            for(int i = 0; i < smallTwo.length; i++) {
                if(num < smallTwo[i]) {
                    temp = smallTwo[i];
                    smallTwo[i] = num;
                    num = temp;
                }
            }

        }

        //return Arrays.stream(bigThree).
        return Math.max(bigThree[0] * bigThree[1] * bigThree[2], smallTwo[0] * smallTwo[1] * bigThree[0]);
    }

    public static void main(String[] args) {
        int ans = maximumProduct(new int[] {-1, -2, -3});
        System.out.println(ans);
    }
}
