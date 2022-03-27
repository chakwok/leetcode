package easy;

public class Q408ValidWordAbbreviation{
    public static void main(String[] args) {
        var app = new Q408ValidWordAbbreviation();
        System.out.println(app.validWordAbbreviation("hi", "2i"));
        System.out.println(app.validWordAbbreviation("substitution", "s10n"));
        System.out.println(app.validWordAbbreviation("substitution", "sub4u4"));
        System.out.println(app.validWordAbbreviation("substitution", "12"));
        System.out.println(app.validWordAbbreviation("substitution", "su3i1u2on"));
        System.out.println(app.validWordAbbreviation("substitution", "substitution"));
        System.out.println(app.validWordAbbreviation("substitution", "s55n"));
        System.out.println(app.validWordAbbreviation("substitution", "s010n"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int idxAbbr = 0;
        int idxWord = 0;
        while(idxAbbr < abbr.length() && idxWord < word.length()) {
            char curr = abbr.charAt(idxAbbr);
            if(isLetter(curr)) {
                if(curr != word.charAt(idxWord)) {
                    return false;
                } else {
                    idxAbbr++;
                    idxWord++;
                }
            } else {
                if(curr == '0') {
                    return false;
                }
                int start = idxAbbr++;
                while(idxAbbr < abbr.length() && isNumber(abbr.charAt(idxAbbr))) {
                    idxAbbr++;
                }
                int count = Integer.parseInt(abbr.substring(start, idxAbbr));
                while(count > 0 && idxWord < word.length()) {
                    idxWord++;
                    count--;
                }
                if(count > 0) {
                    return false;
                }
            }
        }
        return idxWord == word.length() && idxAbbr == abbr.length();
    }

    private boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }


}