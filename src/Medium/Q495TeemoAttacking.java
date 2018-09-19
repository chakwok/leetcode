package Medium;

public class Q495TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        int totalDuration = duration;

        for(int i = 1; i < timeSeries.length; i++) {
            totalDuration += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return totalDuration;
    }


    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        //int totalDuration = 0;
        int prevShot = timeSeries[0];
        int totalOverlap = 0;

        int overlap = 0;

        for(int i = 1; i < timeSeries.length; i++) {
            if ((overlap = timeSeries[i] - prevShot) < duration) {
                totalOverlap += duration - (timeSeries[i] - prevShot);
            }
            //totalDuration =;


            prevShot = timeSeries[i];
        }

        return timeSeries.length * duration - totalOverlap;
    }

    public static void main(String[] args) {
        int ans = findPoisonedDuration(new int[] {1, 2, 3, 4, 5}, 5);
        int ans2 = findPoisonedDuration(new int[] {1, 2}, 2);
        System.out.printf("%d, %d", ans, ans2);
    }
}
