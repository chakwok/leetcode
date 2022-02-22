package easy;

public class Q171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        var app = new Q171ExcelSheetColumnNumber();
        System.out.println(app.titleToNumber("A"));
        System.out.println(app.titleToNumber("AB"));
        System.out.println(app.titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        int n  = columnTitle.length();
        int out = 0;
        for(int i = n - 1; i >= 0 ; i--) {
            int pow = n - i - 1;
            int val = columnTitle.charAt(i) - 'A' + 1;
            out += val * Math.pow(26, pow);
        }
        return out;
    }
}
