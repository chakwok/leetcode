package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1103DistributeCandiestoPeople {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int pos =  0;
        int toDistribute = 1;

        while(candies != 0) {
            if(pos == num_people) {
                pos = 0;
            }

            if(candies < toDistribute) {
                result[pos] += candies;
                candies = 0; // just to restore the property, not useful for this question
                break;
            } else {
                result[pos] += toDistribute;
                candies -= toDistribute;
            }

            toDistribute++;
            pos++;
        }

        return result;
    }
}
