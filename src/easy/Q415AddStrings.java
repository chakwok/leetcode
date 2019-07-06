package easy;

import java.math.BigInteger;

public class Q415AddStrings {
    //The 4ms result can be optimized to 1ms by replacing the StringBuilder by fixed length char[].
    public static String addStringsWithChar(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        char[] val = new char[len];

        boolean carry = false;
        for(int i = 0; i < len; i++) {
            int temp = carry? 1: 0;
            if(num1.length() > i) {
                temp +=  num1.charAt(num1.length() - 1 - i) -'0';
            }

            if(num2.length() > i) {
                temp +=  num2.charAt(num2.length() - 1 - i) -'0';
            }

            if(temp >= 10) {
                carry = true;
                temp = temp%10;
            } else {
                carry = false;
            }

            val[len - 1 - i] = (char)(temp + '0');
        }


        return carry ? ("1" + new String(val)) : new String(val);
    }

    //4ms
    public static String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();

        boolean carry = false;
        for(int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int temp = carry? 1: 0;
            if(num1.length() > i) {
                temp +=  num1.charAt(num1.length() - 1 - i) -'0';
            }

            if(num2.length() > i) {
                temp +=  num2.charAt(num2.length() - 1 - i) -'0';
            }

            if(temp >= 10) {
                carry = true;
                temp = temp%10;
            } else {
                carry = false;
            }

            sum.insert(0, temp);
        }

        if(carry) {
            sum.insert(0, 1);
        }

        return sum.toString();
    }

    public static String addStringsNoBigInteger(String num1, String num2) {
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger multiply = BigInteger.valueOf(1);

        boolean carry = false;
        for(int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int temp = carry? 1: 0;
            if(num1.length() > i) {
                temp +=  num1.charAt(num1.length() - 1 - i) -'0';
            }

            if(num2.length() > i) {
                temp +=  num2.charAt(num2.length() - 1 - i) -'0';
            }

            if(temp >= 10) {
                carry = true;
                temp = temp%10;
            } else {
                carry = false;
            }

            sum = sum.add(BigInteger.valueOf(temp).multiply(multiply));
            multiply = multiply.multiply(BigInteger.valueOf(10));
        }

        if(carry) {
            sum = sum.add(multiply);
        }

        return sum.toString();
    }

    // not able to handle bigger input
    public static String addStringsTooSmall(String num1, String num2) {
        int sum = 0;
        int multiply = 1;

        boolean carry = false;
        for(int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int temp = carry? 1: 0;
            if(num1.length() > i) {
                temp +=  num1.charAt(num1.length() - 1 - i) -'0';
            }

            if(num2.length() > i) {
                temp +=  num2.charAt(num2.length() - 1 - i) -'0';
            }

            if(temp >= 10) {
                carry = true;
                temp = temp%10;
            } else {
                carry = false;
            }

            sum += temp * multiply;
            multiply *= 10;
        }

        if(carry) {
            sum += multiply;
        }

        return String.valueOf(sum);
    }

    public static void main(String[] args) {
//        System.out.println(addStringsTooSmall());
        System.out.println(addStringsWithChar("310", "20"));
        System.out.println(addStrings("311312312312421412412412412412421412412412412", "3113123123124214124124124124124214124124124123212312"));
        System.out.println(addStringsWithChar("311312312312421412412412412412421412412412412", "3113123123124214124124124124124214124124124123212312"));
        BigInteger val1 = new BigInteger("311312312312421412412412412412421412412412412");
        BigInteger val2 = new BigInteger("3113123123124214124124124124124214124124124123212312");
        System.out.println(val1.add(val2));
    }


}
