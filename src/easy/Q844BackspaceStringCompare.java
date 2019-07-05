package easy;

public class Q844BackspaceStringCompare {
    // start from the end
// update sNext, tNext
// check if they are the same
// continue until one of them reach 0
// compare charAt(0)
    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;

        char sNext = S.charAt(i);
        char tNext = T.charAt(j);
        int sBack = 0;
        int tBack = 0;

        while(i >= 0 || j >= 0) {
            while(i >= 0 && (sNext = S.charAt(i)) == '#' || sBack > 0 && sNext != '#' ) {
                if(sNext == '#') {
                    sBack++;
                } else {
                    sBack--;
                }
                i--;

            }

            while(j >= 0 && (tNext = T.charAt(j)) == '#' || tBack > 0 && tNext != '#') {
                if(tNext == '#') {
                    tBack++;
                } else {
                    tBack--;
                }
                j--;
            }

            if(i>=0 && j >= 0 && sNext != tNext) {
                return false;
            } else if((i < 0  ^ j < 0)) {
                return false;
            }


            i--;
            j--;
        }
        return true;
    }

    // have to be doen in O(1) space
    /*
    private String resolveString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '#') {
//                sb.append()
            }
        }

        return null;
    }*/


}
