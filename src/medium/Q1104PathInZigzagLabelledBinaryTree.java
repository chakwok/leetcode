package medium;

import java.util.LinkedList;
import java.util.List;

public class Q1104PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(15));
        System.out.println(pathInZigZagTree(14));
        System.out.println(pathInZigZagTree(26));
    }

    public static List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        while(label > 0) {
            result.addFirst(label);
            label /= 2;
        }

        /*System.out.println(result);*/
        int toInvert;
        if(result.size() %2 == 0) {
            toInvert = 0;
        } else {
            toInvert = 1;
        }

        for(int i = 0; i < result.size(); i++) {
            if(i % 2 == toInvert) {
                result.set(i, invert(result.get(i), i ));
            }
        }

        return result;
    }

    public static int invert(int num, int depth) {
        if(depth == 0) {
            return num;
        }

        final int hi = (int) (2 * Math.pow(2, depth) - 1);
        final int lo = (int) Math.pow(2, depth);
        return lo + (hi - num);
    }

    public static List<Integer> pathInZigZagTreeOld(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        while(label != 0) {
            result.addFirst(label);
            if(label % 2 == 1) {
                label = label / 2 ;
            } else {
                label /= 2;
            }

        }

        int level = 1;
        for(int i = 0; i < result.size(); i++) {
            if(i%2 == 1) {
                int diff = (int) Math.pow(2, level + 1) - 1-  result.get(i) - result.get(i) - (int)Math.pow(2, level);
                if(diff > 0) {
                    result.set(i, (int) Math.pow(2, level) + diff);
                } else {
                    diff = Math.abs(diff);
                    result.set(i, (int) Math.pow(2, level + 1) - diff);
                }
//                int diff = Math.min();


                level += 1;
            }

        }

        return result;


    }
}
