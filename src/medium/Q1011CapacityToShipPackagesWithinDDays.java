package medium;

public class Q1011CapacityToShipPackagesWithinDDays{
    public static void main(String[] args) {
        var app = new Q1011CapacityToShipPackagesWithinDDays();
        System.out.println(app.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(app.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE, right = 0;
        for(int w : weights) {
            if(w > left) {
                left = w;
            }
            right += w;
        }

        outer: while(left != right) {
            int cap = left + (right - left)/2 ;
            int curr = 0;
            int day = 1;
            for(int w : weights) {
                if(w + curr > cap) {
                    day++;
                    curr = w;
                    if(day > days) {
                        left = cap + 1;
                        continue outer;
                    }
                } else {
                    curr += w;
                }
            }

            right = cap;
        }
        return left;
    }

    public int shipWithinDaysSlow(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if(weights[i] > max) {
                max = weights[i];
            }
        }

        int cap = Math.max(sum / days, max);
        outer: while(true) {
            int remaining = cap;
            int day = 0;
            for(int i = 0; i < weights.length; i++) {
                if(remaining >= weights[i]) {
                    remaining -= weights[i];
                } else {
                    if(++day >= days) {
                        cap++;
                        continue outer;
                    } else {
                        remaining = cap - weights[i];
                    }
                }
            }

            return cap;
        }
    }
}