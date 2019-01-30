package easy;

public class Q771JewelsAndStones {
    //18ms; Time Complexity O(n)
    public static int numJewelsInStones1(String J, String S) {
        String removeJewels = S.replaceAll("[" + J + "]","");
        return S.length() - removeJewels.length();
    }

    //18ms
    public static int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    //Time Complexity O(n)
    public static int numJewelsInStones(String J, String S) {

        boolean[] arr = new boolean[128];

        //find out which char is exist in the J
        //0-32 is probably useless. but no harm to be here;
        for (int i = 0; i < J.length(); i ++) {
            arr[J.charAt(i)] = true;
        }

        int count = 0;

        for (int j = 0; j < S.length(); j++) {
            if (arr[S.charAt(j)]) {
                count++;
            }
        }
        return count;
    }
}
