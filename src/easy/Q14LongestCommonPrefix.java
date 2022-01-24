package easy;

public class Q14LongestCommonPrefix {
    public static void main(String[] args) {
        var app = new Q14LongestCommonPrefix() ;
        System.out.println(app.longestCommonPrefix(new String[] {"ab", "a"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }

        char[] longest = strs[0].toCharArray();
        for(int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            for(int j = 0; j < longest.length; j++) {
                if(j >= curr.length()) {
                    longest[j] = '#';
                }

                if(longest[j] == '#') {
                    break;
                }

                if(curr.charAt(j) != longest[j]) {
                    if(j == 0) return "";
                    longest[j] = '#';
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : longest) {
            if(ch != '#') {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
