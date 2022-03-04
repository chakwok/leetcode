package medium;

public class Q921MinimumAddtoMakeParenthesesValid{
    public int minAddToMakeValid(String s) {
        int out = 0;
        int curr = 0;
        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                curr++;
            } else if(ch == ')') {
                if(curr == 0) {
                    out++;
                } else {
                    curr--;
                }
            }
        }
        out += curr;
        return out;
    }
}