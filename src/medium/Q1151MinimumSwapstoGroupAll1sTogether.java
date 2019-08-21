package medium;

public class Q1151MinimumSwapstoGroupAll1sTogether {
    public int minSwaps(int[] data) {
        int ones = countOnes(data, 0, data.length - 1);

        int firstWindowZeros = ones - countOnes(data, 0, ones - 1);
        int min = firstWindowZeros;
        int curr = firstWindowZeros;

        for(int i = 0; i < data.length - ones; i++) {
            curr -= data[i] == 0? 1: 0;
            curr += data[i + ones] == 0? 1: 0;

            min = Math.min(min, curr);
        }

        return min;
    }

    private int countOnes(int[] data, int from, int to) {
        int count = 0;
        for(int i = from; i <= to; i++) {
            count += data[i] == 1? 1: 0;
        }
        return count;
    }

    public int minSwapsFail(int[] data) {
        int count = 0;
        for(int i = 0; i < data.length; i++) {
            if(data[i] == 1) {
                count++;
            }
        }

        int min = Integer.MAX_VALUE;
        int zeros = 0;

        for(int j = 0; j < count; j++) {
            if(data[j] == 0) {
                zeros++;
            }
        }

        if(count == 0) {
            return 0;
        }

        for(int k = 1; k < data.length - count; k++) {
            if(data[k - 1] == 1) {
                zeros--;
            }

            if(data[k + count]  == 1) {
                zeros++;
            }

            min = Math.min(zeros, min);
        }


        return min;
    }
    //slow O(n^2)
    public int minSwapsOld(int[] data) {
        int count = 0;
        for(int i = 0; i < data.length; i++) {
            if(data[i] == 1) {
                count++;
            }
        }

        int min = Integer.MAX_VALUE;
        int zeros = 0;

        for(int j = 0; j < count; j++) {
            if(data[j] == 0) {
                zeros++;
            }
        }

        if(count == 1) {
            return 0;
        }

        for(int k = 1; k < data.length - count; k++) {
            if(data[k - 1] == 0) {
                zeros--;
            }

            if(data[k + count - 1]  == 0) {
                zeros++;
            }

            min = Math.min(zeros, min);
        }


        return min;
    }

    public static void main(String[] args) {
        Q1151MinimumSwapstoGroupAll1sTogether app = new Q1151MinimumSwapstoGroupAll1sTogether();
        System.out.println(app.minSwaps(new int[]{1,0,1,0,1}));
        System.out.println(app.minSwaps(new int[]{0,0,0,1,0}));
        System.out.println(app.minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}));
    }
}
