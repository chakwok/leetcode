package easy;

import java.util.Stack;

public class Q917ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int head = 0;
        int tail = S.length() - 1;

        char[] letters = S.toCharArray();

        while(true) {
            //find non-symbol
            while(head < letters.length - 1 && letters[head] < 65) {
                head++;
            }

            //find non-symbol
            while(tail > 0 && letters[tail] < 65) {
                tail--;
            }

            if(tail > head) {
                char temp = letters[tail];
                letters[tail] = letters[head];
                letters[head] = temp;

                tail--;
                head++;
            } else {
                break;
            }
        }

        return String.valueOf(letters);
    }

    public static String reverseOnlyLettersSol(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLettersSol("7_28]"));
    }
}
