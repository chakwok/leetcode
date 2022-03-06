package easy;

public class Q125ValidPalindrome{
    public static void main(String[] args) {
        var app = new Q125ValidPalindrome();
        System.out.println(app.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(app.isPalindrome("race a car"));
        System.out.println(app.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while(lo < hi) {
            while(lo < hi && toCompare(s.charAt(lo)) == null) {
                lo++;
            }
            while(lo < hi && toCompare(s.charAt(hi)) == null) {
                hi--;
            }
            if(lo >= hi) {
                return true;
            }
            if(toCompare(s.charAt(lo)) != toCompare(s.charAt(hi))) {
                return false;
            } else {
                lo++;
                hi--;
            }
        }
        return true;
    }

    private Character toCompare(char ch) {
        if(ch >= 'A' && ch <= 'Z') {
            return Character.toLowerCase(ch);
        } else if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
            return ch;
        } else return null;
    }
}