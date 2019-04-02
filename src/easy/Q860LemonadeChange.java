package easy;

public class Q860LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int[] billsOnHand = new int[3]; //keeping track of $20 bill is not necessary, but nice to have
        for(int bill: bills) {
            if(bill == 5) {
                billsOnHand[0]++;
            } else if(bill == 10){
                if(billsOnHand[0] >= 1) {
                    billsOnHand[0]--;
                    billsOnHand[1]++;
                } else {
                    return false;
                }
            } else if(bill == 20) {
                if(billsOnHand[1] >= 1 && billsOnHand[0] >= 1) {
                    billsOnHand[2]++;
                    billsOnHand[0]--;
                    billsOnHand[1]--;
                } else if(billsOnHand[0] >= 3) {
                    billsOnHand[2]++;
                    billsOnHand[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        lemonadeChange(new int[]{5,5,5,10,20});
    }
}
