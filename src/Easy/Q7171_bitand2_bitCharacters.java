package Easy;

public class Q7171_bitand2_bitCharacters {
    public static boolean isOneBitCharacter(int[] bits) {
        boolean isLeadingOne = false;
        for(int i = 0; i < bits.length - 1; i++) {
            if(!isLeadingOne && bits[i] == 1) {
                isLeadingOne = true;
            } else if(isLeadingOne) {
                isLeadingOne = false;
            }
        }
        return !isLeadingOne && bits[bits.length - 1] == 0;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{0}));
        System.out.println(isOneBitCharacter(new int[]{1}));
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 0, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    public static boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        //if it's odd, it means there's a leading one to that zero
        return (bits.length - i) %2 == 0;
    }
}
