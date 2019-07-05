package easy;

public class Q557ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int start = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                for(int j = i - 1; j >= start; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                start = i + 1;
            }
        }

        if(s.charAt(s.length() - 1) != ' ') {
            for(int j = s.length() - 1; j >= start; j--) {
                sb.append(s.charAt(j));
            }
        }

        return sb.toString();
    }
}
