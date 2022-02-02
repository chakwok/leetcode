package medium;

public class Q134GasStation {
    public static void main(String[] args) {
        var app = new Q134GasStation();
        System.out.println(app.canCompleteCircuit(new int[]{4}, new int[]{5}));
        System.out.println(app.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        System.out.println(app.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }


    public int canCompleteCircuitCleaner(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i]; //dped the total surplus to avoid actually going thru
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] >= cost[0]? 0 : -1;
        }

/*        int[] delta = new int[gas.length];
        for (int i = 0; i < delta.length - 1; i++) {
            delta[i] = gas[i + 1] - cost[i];
        }
        delta[delta.length - 1] = gas[0] - cost[delta.length - 1];*/

        int n = gas.length;

        int i = 0;
        label: while (i < n) {
            int step = 0;
            int tank = gas[i];
            while (step < gas.length) {
                int j = i + step;
                if(tank - cost[j % n] < 0) {
                    i = j + 1;
                    continue label;
                }

                tank += gas[(j + 1) % n] - cost[j % n];
                step++;
            }
            return i;
        }

        return -1;
    }
}
