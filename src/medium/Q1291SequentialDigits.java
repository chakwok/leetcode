package medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q1291SequentialDigits {
    public static void main(String[] args) {
        var app = new Q1291SequentialDigits();
        System.out.println(app.sequentialDigits(1000, 13000));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        /*int length = 0;
        int mod = low / 10;
        while(mod > 0) {
            length++;
            mod /= 10;
        }*/

        List<Integer> ans = new LinkedList<>();
        for(int i = 1; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j <= 9; j++) {
                sb.append(j);
                int curr = Integer.parseInt(sb.toString());
                if(curr > high) {
                    break;
                } else if(curr >= low) {
                    ans.add(curr);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
