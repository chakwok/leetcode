package medium;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Q1093StatisticsfromaLargeSample {
    public static void main(String[] args) {
        double[] res = (sampleStats(new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(Arrays.toString(res));

        double[] res2 = sampleStats(new int[]{0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        System.out.println(Arrays.toString(res2));
    }

    public static double[] sampleStats2(int[] count) {

        double mode = -1;
        double modeCount = 0;
        BigDecimal mean = BigDecimal.valueOf(0);
        double min = -1;
        double max = Integer.MIN_VALUE;
        int valCount = 0;
        double median = 0;

        for(int i = 0; i < count.length; i++) {
            if(min == -1 && count[i] != 0 ) {
                min = i;
            }

            if(count[i] != 0) {
                max = i;
                mean = mean.add(BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(count[i])));
                valCount += count[i];
                if(count[i] > modeCount) {
                    modeCount = count[i];
                    mode = i;
                }
//                mode = Math.max(mode, count[i]);
            }
        }

        int toFind;
        int toFind2;
        int val = 0;
        if(valCount%2 == 1) {
            toFind = valCount / 2;
            label: for(int i = 0; i < count.length; i++) {
                for(int j = 0; j < count[i]; j++) {
                    if(val == toFind) {
                        median = i;
                        break label;
                    }
                    val++;
                }
            }
        } else if(valCount%2 == 0) {
            toFind =valCount/2;
            toFind2 = valCount/2 - 1;
            label2: for(int i = 0; i < count.length; i++) {
                for(int j = 0; j < count[i]; j++) {

                    if(val == toFind || val == toFind2) {
                        median += i;
                        if(val == toFind) {
                            break label2;
                        }
                    }
                    val++;
                }
            }

            median /= 2;
        }

        double[] res = new double[]{min, max, mean.divide(BigDecimal.valueOf(valCount), 10, RoundingMode.HALF_EVEN).doubleValue(), median, mode};
        return res;
    }



    public static double[] sampleStats(int[] count) {

        double mode = -1;
        double modeCount = 0;
        double mean = 0;
        double min = -1;
        double max = Integer.MIN_VALUE;
        int valCount = 0;
        double median = 0;

        for(int i = 0; i < count.length; i++) {
            if(min == -1 && count[i] != 0 ) {
                min = i;
            }

            if(count[i] != 0) {
                max = i;
                mean += i * count[i];
                valCount += count[i];
                if(count[i] > modeCount) {
                    modeCount = count[i];
                    mode = i;
                }
//                mode = Math.max(mode, count[i]);
            }
        }

        int toFind;
        int toFind2;
        int val = 0;
        if(valCount%2 == 1) {
            toFind = valCount / 2;
            label: for(int i = 0; i < count.length; i++) {
                for(int j = 0; j < count[i]; j++) {
                    if(val == toFind) {
                        median = i;
                        break label;
                    }
                    val++;
                }
            }
        } else if(valCount%2 == 0) {
            toFind =valCount/2;
            toFind2 = valCount/2 - 1;
            label2: for(int i = 0; i < count.length; i++) {
                for(int j = 0; j < count[i]; j++) {

                    if(val == toFind || val == toFind2) {
                        median += i;
                        if(val == toFind) {
                            break label2;
                        }
                    }
                    val++;
                }
            }

            median /= 2;
        }

        double[] res = new double[]{min, max, mean/valCount, median, mode};
        return res;
    }
}
