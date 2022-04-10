package contest.weekly;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Contest288 {
    public static void main(String[] args) {
        var app = new Contest288();
//        System.out.println(app.largestInteger(1234));
//        System.out.println(app.largestInteger(65875));
//        System.out.println(app.maximumProduct(new int[] {571,478,284,91,439,93,574,176,236,104,810,137,986,534,330,266,351,629,466,133,94,207,288,27,388,705,248,536,289,879,469,58,350,691,703,238,79,67,410,974,747,664,364,823,422,665,923,886,56,77,317,826,339,264,120,206,215,428,737,386,804,291,293,438,307,599,619,393,95,419,436,564,629,532,993,76,59,535,507,336,998,274,897,985,148,539,34,259,253,281,525,259,674,544,203,104,371,118,344,782,399,606,548,531,612,186,712,756,848,585,293,625,547,62,281,654,536,409,941,700,804,113,883,851,707,826,308,855,582,293,787,141,812,323,413,343,838,537,553,935}, 955));
        /*Output:
            706814797
        Expected:
            761619927
        */
//        System.out.println(app.maximumProduct(new int[] {92,36,15,84,57,60,72,86,70,43,16}, 62)); //expects 800222867, out 291172003
//        System.out.println(app.maximumProduct(new int[] {92,36,15,84,57,60,72,86,70,43,16}, 62)); //expects 800222867, out 291172003


//        System.out.println(app.maximumProduct(new int[] {0,4}, 5));
//        System.out.println(app.maximumProduct(new int[] {6,3,3,2}, 2));
//        System.out.println(app.minimizeResult( "247+38"));
        System.out.println(app.minimizeResult( "12+34"));
        System.out.println(app.minimizeResult( "999+999"));
    }
    int min = Integer.MAX_VALUE;
    int[] pair = new int[2];
    public String minimizeResult(String expression) {
        minimizeResult(expression, 0, expression.length() - 1);
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(pair[1] + 1   , ')');
        sb.insert(pair[0], '(');
        return sb.toString();
    }

    private void minimizeResult(String expression, int front , int back) {
        int plus = expression.indexOf('+');
        if(front == plus || back == plus) {
            return;
        }
        eval(expression, front, back);
        minimizeResult(expression, front + 1, back);
        minimizeResult(expression, front, back - 1);
    }


    private void eval(String str, int front, int back) {
        int plus = str.indexOf('+');
//        int front = str.indexOf('(');
        int first = (front == 0)? 1 : Integer.parseInt(str.substring(0, front));

//        int back = str.indexOf(')');
        int third = (back == str.length() - 1)? 1 : Integer.parseInt(str.substring(back + 1));


        int second = Integer.parseInt(str.substring(front, plus)) + Integer.parseInt(str.substring(plus + 1, back + 1));
        int ans = first * second * third;
        if(ans < min) {
            min = ans;
            pair[0] = front;
            pair[1] = back;
        }
    }



    final BigInteger MOD = BigInteger.valueOf(1_000_000_007);
    public int maximumProduct(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            int count = 1 + map.getOrDefault(num, 0);
            map.put(num, count);
        }

        while(k > 0) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            if(entry.getValue() == 1) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue() - 1);
            }
            int key = entry.getKey() + 1;
            int count = 1 + map.getOrDefault(key , 0);
            map.put(key, count);

            k--;
        }

        BigInteger out = BigInteger.ONE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                BigInteger mul = BigInteger.valueOf(entry.getKey());
                out = out.multiply(mul);
                out = out.mod(MOD);
            }
        }

        return out.intValue();
    }

    public int largestInteger(int num) {
        String str = Integer.toString(num);

        LinkedList<Character> odds = new LinkedList<>();
        LinkedList<Character> evens = new LinkedList<>();

        for(int i = 0 ; i < str.length(); i++) {
            if(isOdd(str, i)) {
                odds.add(str.charAt(i));
            } else {
                evens.add(str.charAt(i));
            }
        }

        odds.sort(Comparator.reverseOrder());
        evens.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i++) {
            char curr;
            if (isOdd(str, i)) {
                curr = odds.pop();
            } else {
                curr = evens.pop();
            }
            sb.append(curr);
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isOdd(String str, int i) {
        return (str.charAt(i) - '0') % 2 == 1;
    }

}
