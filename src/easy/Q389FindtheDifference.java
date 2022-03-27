package easy;

public class Q389FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for(int i = 0 ; i < s.length() ;i++) {
            arrS[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < t.length() ;i++) {
            arrT[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < arrS.length; i++) {
            if(arrS[i] != arrT[i]) {
                return (char) ('a' + i);
            }
        }

        return '#';
    }
}
