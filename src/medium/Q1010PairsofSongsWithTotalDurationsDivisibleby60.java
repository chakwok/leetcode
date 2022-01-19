package medium;

public class Q1010PairsofSongsWithTotalDurationsDivisibleby60 {
    public static void main(String[] args) {
        Q1010PairsofSongsWithTotalDurationsDivisibleby60 app = new Q1010PairsofSongsWithTotalDurationsDivisibleby60();
//        System.out.println(app.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));;
//        System.out.println(app.numPairsDivisibleBy60(new int[]{60,60,60}));;
        System.out.println(app.numPairsDivisibleBy60(new int[]{15,63,451,213,37,209,343,319}));;
    }
//(1+2) * 2 / 2
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for(int t : time) {
            mod[t%60]++;
        }

        int sum = 0 ;
        for(int i = 1; i < 30 ; i++) {
            int j = 60 - i;
            sum += mod[i] * mod[j];
        }

        for(int i : new int[] {0,30}) {
            if(mod[i] > 1) {
                sum += sum(mod[i] - 1);
            }
        }

        return sum;
    }

    static int sum(int n)
    {
        return (1 + n) * n / 2;
    }
}
