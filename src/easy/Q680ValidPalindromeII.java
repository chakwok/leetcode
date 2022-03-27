package easy;

public class Q680ValidPalindromeII{
    public static void main(String[] args) {
        var app = new Q680ValidPalindromeII();
        System.out.println(app.validPalindrome( "aba"));
        System.out.println(app.validPalindrome( "abca"));
        System.out.println(app.validPalindrome( "abc"));
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    /*public boolean validPalindrome(String s) {
        int n = s.length();
        if(n <= 2) {
            return true;
        }
        if(n%2 == 1) {
            int[] front = new int[26];
            for(int i = 0; i < s.length() / 2; i++) {
                front[s.charAt(i) - 'a']++;
            }
            int[] back = new int[26];
            for(int i = s.length() / 2; i < s.length(); i++) {
                back[s.charAt(i) - 'a']++;
            }
            if(isDiffByOne(front, back)) {
                return true;
            }
            int mid = s.charAt(s.length() / 2) - 'a';
            front[mid]++;
            back[mid]--;
            return isDiffByOne(front, back);

        }
    }*/

    /*public boolean validPalindrome(String s) {
        int[] front = new int[26];
        for(int i = 0; i < s.length() / 2; i++) {
            front[s.charAt(i) - 'a']++;
        }
        int[] back = new int[26];
        for(int i = s.length() / 2; i < s.length(); i++) {
            back[s.charAt(i) - 'a']++;
        }
        if(isDiffByOne(front, back)) {
            return true;
        } else if(s.length() % 2 == 1) {
            int mid = s.charAt(s.length() / 2) - 'a';
            front[mid]++;
            back[mid]--;
            return isDiffByOne(front, back);
        } else return false;
    }*/

    private boolean isDiffByOne(int[] front, int[] back) {
        int diff = 0;
        for(int i = 0; i < front.length; i++) {
            int currDiff = Math.abs(front[i] - back[i]);
            if(currDiff == 1) {
                if(diff == 0) {
                    diff = 1;
                } else {
                    return false;
                }
            } else if(currDiff > 1) {
                return false;
            }
        }

        return true;
    }
}