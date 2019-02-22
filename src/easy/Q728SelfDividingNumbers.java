package easy;

import java.util.ArrayList;
import java.util.List;

public class Q728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isSelfDiving(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isSelfDiving(int num) {
        if(num == 0) {
            return false;
        }

        int digits = num;
        while(digits != 0) {
            int remainder = digits % 10;
            if(remainder == 0) {
                return false;
            } else if(num%remainder == 0){
                digits /= 10;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isSelfDiving(21);
    }
}
