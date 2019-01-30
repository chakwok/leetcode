package easy;

public class Q806NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[] {0, 0};
        }

        int lineCount = 1;
        int wordCount = 0;
        for(int i = 0; i < S.length(); i++) {
            int charWidth = widths[S.charAt(i) - 'a'];
            if(wordCount + charWidth > 100) {
                lineCount += 1;
                wordCount = charWidth;
            } else {
                wordCount += charWidth;
            }
        }
        return new int[] {lineCount, wordCount};
    }
}
