package medium;

import java.util.Stack;

public class Q946ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();

        int pushIdx = 0;
        stack.push(pushed[pushIdx++]);
        for(int i = 0; i < popped.length; i++) {
            while(stack.peek() != popped[i]) {
                if(pushIdx < pushed.length) {
                    stack.push(pushed[pushIdx++]);
                } else {
                    return false;
                }
            }
            stack.pop();
            if(stack.empty() && pushIdx < pushed.length) {
                stack.push(pushed[pushIdx++]);
            }
        }
        return true;
    }
}