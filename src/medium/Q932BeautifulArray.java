package medium;

import java.util.ArrayList;

public class Q932BeautifulArray {
    //some situation that can't exist:
    //   any continuous sequences that have 3 elements+  (e.g. 2,3,4) in any forward-moving way

    public int[] beautifulArrayOld(int N) {
        int[] arr = new int[N];

        if (N % 2 == 1) {
            arr[N] = N;
        }

        for (int i = 1; i < N / 2; i ++) {

        }
        return new int[0];
    }


    public static int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : res) if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            for (int i : res) if (i * 2 <= N) tmp.add(i * 2);
            res = tmp;
            System.out.println(res);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        beautifulArray(5);
    }

}
