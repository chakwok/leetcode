package easy;

import java.util.Stack;

public class Q682BaseballGame{
    public static void main(String[] args) {
        var app = new Q682BaseballGame();
        System.out.println(app.calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(app.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
        System.out.println(app.calPoints(new String[] {"1"}));
    }
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int out = 0;

        for(String op : ops) {
            int score = 0;
            if(op.equals("+")) {
                score = stack.peek() + stack.get(stack.size() - 2);
                stack.push(score);
            } else if(op.equals("C")) {
                score = -stack.pop();
            } else if(op.equals("D")) {
                score = stack.peek() * 2;
                stack.push(score);
            } else {
                score = Integer.parseInt(op);
                stack.push(score);

            }

            out += score;
        }
        return out;
    }
}