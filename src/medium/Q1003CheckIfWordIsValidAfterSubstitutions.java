package medium;

import java.util.Stack;

public class Q1003CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {
        var app = new Q1003CheckIfWordIsValidAfterSubstitutions();
        System.out.println(app.isValid("aabcbc"));
        System.out.println(app.isValid("abc"));
        System.out.println(app.isValid("abcabcababcc"));
        System.out.println(app.isValid("abccba"));
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            if(ch == 'a') {
                stack.push("a");
            } else if (stack.size() == 0) {
                return false;
            } else {
                String curr = stack.pop();

                if(ch == 'b') {
                    if(curr.equals("a")) {
                        stack.push("ab");
                    } else return false;
                } else if(ch == 'c') {
                    if(!curr.equals("ab")) {
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }
}
