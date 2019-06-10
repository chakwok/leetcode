package medium;

public class Q227BasicCalculatorII {
    public static int calculate(String s) {
        int result = 0;
        int presign = 1; // 1 for +ve ; -1 for -ve;
        int operator = 1; // 1 for +, -; 2 for '*' 3 for '/'
        int intermediate = 0;

        s = s + "+"; // to end the operation
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == ' ') {
                continue;
            } else if(ch == '+' || ch == '-') {
                result += intermediate * presign;
                intermediate = 0;
                operator = 1;
                presign = ch == '+'? 1: -1;
            } else if(ch == '*') {
                operator = 2;
            } else if(ch == '/') {
                operator = 3;
            } else{
                if(operator == 1) {
                    intermediate = intermediate * 10 + (ch - '0');
                } else{ // *, /
                    int start = i;
                    while(i < s.length() && Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    if(operator == 2) {
                        intermediate *= Integer.valueOf(s.substring(start, i));
                    } else {
//                        System.out.println(intermediate + "/ by");
//                        System.out.println(s.substring(start, i));
                        intermediate /= Integer.valueOf(s.substring(start, i));
                    }
                    i--;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println(calculate(" 3+5 / 2 "));
    }
}
