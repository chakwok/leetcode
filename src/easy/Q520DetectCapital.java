package easy;

public class Q520DetectCapital {
    public static void main(String[] args) {
        var app = new Q520DetectCapital();
        System.out.println(app.detectCapitalUse("USA"));
        System.out.println(app.detectCapitalUse("leetcode"));
        System.out.println(app.detectCapitalUse("Flag"));
        System.out.println(app.detectCapitalUse("FlaG"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        char head = word.charAt(0);
        if(head >= 'a' && head <= 'z') {
            return isAllWithin(word, 1, 'a', 'z');
        } else {
            return isAllWithin(word, 1, 'a', 'z') || isAllWithin(word, 1, 'A', 'Z');
        }
    }

    public boolean isAllWithin(String s, int idx, char start, char end) {
        for(int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch < start || ch > end) {
                return false;
            }
        }
        return true;
    }
}
