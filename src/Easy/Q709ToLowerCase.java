package Easy;

public class Q709ToLowerCase {
    public String toLowerCase1(String str) {
        return str.toLowerCase();
    }

    public String toLowerCase(String str) {
        StringBuffer strBuff = new StringBuffer(str);
        int toLower = - 'A' + 'a';
        for (int i = 0; i < strBuff.length(); i ++) {
            if(strBuff.charAt(i) >= 'A' && strBuff.charAt(i) <= 'Z') {
                strBuff.setCharAt(i, (char)(strBuff.charAt(i) + toLower));
            }
        }
        return strBuff.toString();
    }

}
