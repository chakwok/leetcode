package contest.biweekly;

import java.util.Arrays;
import java.util.LinkedList;

public class BiContest76 {
    public static void main(String[] args) {
        var app = new BiContest76();

//        System.out.p/**/rintln(app.findClosestNumber(new int[]{-4,-2,1,4,8}));
//        System.out.println(app.findClosestNumber(new int[]{2, -1, 1}));
//        System.out.println(app.findClosestNumber(new int[]{2, 1, -1}));
//        System.out.println(app.findClosestNumber(new int[]{2, -1}));
//        System.out.println(app.waysToBuyPensPencils(20, 10, 5));
//        System.out.println(app.waysToBuyPensPencils(2, 10, 5));
        var atm = new ATM();
//        atm.deposit(new int[] {0,10,0,3,0});
//        System.out.println(Arrays.toString(atm.withdraw(500)));
        atm.deposit(new int[] {0,0,1,2,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[] {0,1,0,1,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));

    }
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        int diff = Math.abs(nums[0]);
        for(int num: nums) {
            if(Math.abs(num) < diff) {
                diff = Math.abs(num);
                closest = num;
            } else if(Math.abs(num) == diff && num > closest) {
                closest = num;
            }
        }
        return closest;
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long out = 0;
        int max1 = total / cost1;
        for(int i = 0; i <= max1; i++) {
            int remaining = total - cost1 * i;
            out += 1 + remaining / cost2;
        }
        return out;
    }

    static class ATM {
        final int[] values = new int[]{20, 50, 100, 200, 500};
        long[] notes = new long[5];

        class Entry {
            int amountRemain;
            int[] request;
            int pos;

            public Entry(int amountRemain, int[] request, int pos) {
                this.amountRemain = amountRemain;
                this.request = request;
                this.pos = pos;
            }
        }

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for(int i = 0; i < 5; i++) {
                notes[i] += banknotesCount[i];
            }
        }




        public int[] withdraw(int amount) {
            LinkedList<Entry> q = new LinkedList<>();
            q.push(new Entry(amount, new int[] {0,0,0,0,0}, 4));
            while(q.size() > 0) {
                Entry entry = q.poll();
                int amountRemain =  entry.amountRemain;
                int[] request = entry.request;

                for(int i = entry.pos; i >= 0; i--) {
                    int value = values[i];
                    if(amountRemain >= value) {
                        /*if(notes[i] == 0) {
                            return new int[] {-1};
                        } else*/ {
                            int max = (int) Math.min(notes[i], amountRemain / value);
                            request[i] = max;
                            amountRemain -= max * value;

//                            if(notes[i] - max > 1) {
//                                int [] r = Arrays.copyOf(request, 5);
//                                r[i]--;
//                                q.push(new Entry(amountRemain + value, r, i - 1));
//                            }

                        }
                    }

                }

                if(amountRemain == 0) {
                    for(int i = 0; i < notes.length; i++) {
                        notes[i] -= request[i];
                    }
                    return request;
                }
            }

            return new int[] {-1};
        }
    }

}
