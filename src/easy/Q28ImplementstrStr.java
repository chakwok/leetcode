package easy;

public class Q28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        } else if(needle.length() > haystack.length()) {
            return -1;
        }

        for(int i = 0; i < haystack.length(); i++) {
            if(i + needle.length() - 1 == haystack.length()) {
                return -1;
            }

            for(int j = i;;j++) {
                if(haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
                if(j - i + 1 == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
