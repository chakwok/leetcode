package medium;

import java.util.LinkedList;
import java.util.Stack;

public class Q1249MinimumRemovetoMakeValidParentheses{
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> toRemove = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')') {
                if(!stack.empty()) {
                    stack.pop();
                } else {
                    toRemove.addFirst(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        while(toRemove.size() > 0 && stack.size() > 0) {
            if(toRemove.getFirst() > stack.peek()) {
                sb.deleteCharAt(toRemove.removeFirst());
            } else {
                sb.deleteCharAt(stack.pop());
            }
        }
        while(toRemove.size() > 0) {
            sb.deleteCharAt(toRemove.removeFirst());
        }
        while(stack.size() > 0) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}