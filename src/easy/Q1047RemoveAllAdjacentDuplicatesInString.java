package easy;

public class Q1047RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        for(int i = 0; i < sb.length() - 1; ) {
            if(sb.charAt(i) == sb.charAt(i+1)) {
                sb.delete(i, i + 2);
                if(i > 0) {
                    i-=1;
                }
            } else {
                i++;
            }


        }
        return sb.toString();

    }

    public static void main(String[] args) {
        removeDuplicates("aaaaaaaa");
    }
}
