package hard;

import java.util.Stack;

public class Q224BasicCalculator {
    static int i =0;
    //1ms
    //very elegant solution
    // 1. add a '(' ')' to the origin string, and thus eval the whole thing when encountering ')' only
    // mixing global index with local use might be confusing, but it eliminate the use of stack
    // not so sure why this approach is faster than iterative approach tho. both O(n) runtime
    public static int calculate(String s) {
        i=0;
        s = "(" + s + ")";
        return helper(s);
    }
    static int helper(String s) {
        int num =0;
        int val = 0;
        int presign = 1;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c==' ') {
                i++;
            }else if(c=='+') {
                val = val + presign * num;
                num=0;
                presign = 1;
                i++;
            }else if(c=='-') {
                val = val + presign * num;
                num=0;
                presign = -1;
                i++;
            }else if(c=='(') {
                i++;
                val = val + presign * helper(s);
            }else if(c==')') {
                val = val + presign * num;
                i++;
                return val;
            }else {
                int n = c-'0';
                num = num * 10 + n;
                i++;
            }
        }
        return val;
    }



    public int calculate18ms(String s) {
        if(s == null) return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if(c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1: -1);
                num = 0;

            } else if(c == '(') {
                stack.push(sign);

            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }



    //very slow 87ms
    public static int calculateSlow(String s) {
        s = s.replaceAll("[ ]", "");
        StringBuilder sb = new StringBuilder(s);

        return calculate(sb, 0, s.length(), true);
    }

    private static int calculate(StringBuilder sb, int start, int end, boolean isAdd) {
        int ans = 0;

        int operandStart = start;
        while(start < end) {
            if(sb.charAt(start) == '(') {
                int findClosing = 1;
                start++;

                //start Pos will update to the index of ')' + 1
                while(findClosing > 0) {
                    if(sb.charAt(start) == ')') {
                        findClosing--;
                    } else if(sb.charAt(start) == '(') {
                        findClosing++;
                    }

                    start++;
                }
                start--;
                int val = calculate(sb, operandStart + 1, start, true);
                ans += calculateChange(val, isAdd);
            } else if (sb.charAt(start) == '+') {
                isAdd = true;
            } else if(sb.charAt(start) == '-') {
                isAdd = false;
            } else {
                while(!(sb.length() == start || sb.charAt(start) == '+' || sb.charAt(start) == '-' || sb.charAt(start) == ')')) {
                    start++;
                }
                int val = Integer.valueOf(sb.substring(operandStart, start));
                ans += calculateChange(val, isAdd);

                start--;
            }

            start++;
            operandStart = start;
        }

        return ans;
    }

    private static int calculateChange(int val, boolean isAdd) {
        return isAdd? +val: -val;
    }

    private static int calculateChange(String val, boolean isAdd) {
        return isAdd? Integer.valueOf(val): -Integer.valueOf(val);
    }



    public static void main(String[] args) {
        int ans = calculate("3");
//        int ans = calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(ans);
    }
}
