package easy;

public class Q953VerifyinganAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length - 1; i++) {
            if(alienCompare(words[i], words[i + 1], order) < 0) {
                return false;
            }
        }
        return true;
    }

    private static int alienCompare(String str1, String str2, String order) {
        for(int i = 0; i < str1.length(); i++ ){
            if(i > str2.length() - 1) {
                return -1;
            }

            int order1 = order.indexOf(str1.charAt(i));
            int order2 = order.indexOf(str2.charAt(i));
            if(order1 > order2) {
                return -1;
            } else if(order1 < order2){
                return 1;
            }
        }
        return 1;
    }
}
