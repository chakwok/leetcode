package contest.biweekly;

import java.util.ArrayList;

public class BiContest75 {
    public static void main(String[] args) {
        var app = new BiContest75();
//        app.compress(new char[] {'a','a','a','a','a','b'});
//        System.out.println(app.minBitFlips(10,7));
//        System.out.println(app.minBitFlips(3,4));
//        System.out.println(app.triangularSum(new int[] {1,2,3,4,5}));
//        System.out.println(app.triangularSum(new int[] {5}));
//        System.out.println(app.sumScores("babab"));
//        System.out.println(app.sumScores("azbazbzaz"));
        System.out.println(app.numberOfWays("0001100100")); //38
        System.out.println(app.numberOfWays("001101"));
        System.out.println(app.numberOfWays("111000"));
    }

    public long numberOfWays(String s) {
        ArrayList<Integer> q = new ArrayList<>();
        char prev = s.charAt(0);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == prev) {
                count++;
            } else {
                q.add(count);
                prev = s.charAt(i);
                count = 1;
            }
        }
        q.add(count);

        if(q.size() < 3) {
            return 0;
        }
        long out = 0;

        int sumLeftEven = q.get(0);
        int sumLeftOdd = q.get(1);
        int sumRightEven = 0;
        int sumRightOdd = 0;
        for(int i = 2; i < q.size() ; i++) {
            if(i % 2 == 0) {
                sumRightEven += q.get(i);
            } else {
                sumRightOdd += q.get(i);
            }
        }

        for(int i = 1; i < q.size() - 1; i++) {
            if(i % 2 == 0) {
                out += 1.0 * sumLeftOdd * q.get(i) * sumRightOdd;
                int next = q.get(i + 1);
                sumLeftOdd += next;
                sumRightOdd -= next;
            } else {
                out += 1.0 * sumLeftEven * q.get(i) * sumRightEven;
                int next = q.get(i + 1);
                sumLeftEven += next;
                sumRightEven -= next;
            }

        }
        return out;
    }
    /*
    public long numberOfWays(String s) {
        LinkedList<Integer> q = new LinkedList<>();
        char prev = s.charAt(0);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == prev) {
                count++;
            } else {
                q.push(count);
                prev = s.charAt(i);
                count = 1;
            }
        }
        q.push(count);

        if(q.size() < 3) {
            return 0;
        }
        long out = 0;
        LinkedList<Integer> toRemove = new LinkedList<>();
        double mul = 1;
        Iterator<Integer> iter = q.iterator();
        while(iter.hasNext()) {
            int curr = iter.next();

            mul *= curr;
            toRemove.addLast(curr);
            if(toRemove.size() > 3) {
                mul /= toRemove.removeFirst();
            }
            if(toRemove.size() == 3) {
                out += mul;
            }

        }
        return out;
    }
     */

//    public long sumScores(String s) {
//        StringBuilder sb = new StringBuilder();
//        char[] chars = s.toCharArray();
//
//        HashSet<String> set = new HashSet<>();
//        for(int i = 0; i < s.length(); i++) {
//            sb.append(chars[i]);
//            set.add(sb.toString());
//        }
//
//        sb.delete(0, sb.length());
//        long count = 0;
//        for(int i = s.length() - 1; i >= 0; i--) {
//            sb.insert(0, chars[i]);
//            if(set.contains(sb.toString())) {
//                count += sb.length();
//            }
//        }
//        return count;
//    }

    /*public long sumScores(String s) {
        StringBuilder sb = new StringBuilder("");
        char[] chars = s.toCharArray();
        long count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.insert(0, chars[i]);
            count += lcp(chars, sb);
        }
        return count;
    }

    private long lcp(char[] s, StringBuilder sb) {
        long count = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == s[i]) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }*/

    public int minBitFlips(int start, int goal) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if(((start & 1) ^ (goal & 1)) == 1) {
                count++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return count;
    }

    public int triangularSum(int[] nums) {
        int n = nums.length;
        while(n > 0) {
            for(int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }
        return nums[0];
    }

    public int compress(char[] chars) {
        if(chars.length == 1 ) {
            return 1;
        }
        int slow = 0 ;
        int count = 1;
        for(int i = 1 ; i < chars.length; i++) {
            char prev = chars[i - 1];
            if(chars[i] == prev) {
                count++;
            } else {
                chars[slow++] = prev;
                if(count > 1) {
                    String w = Integer.toString(count);
                    for(int j = 0 ; j < w.length(); j++) {
                        chars[slow++] = w.charAt(j);
                    }
                }
                count = 1;
            }
        }
        chars[slow++] = chars[chars.length - 1];
        if(count > 1) {
            String w = Integer.toString(++count);
            for(int j = 0 ; j < w.length(); j++) {
                chars[slow++] = w.charAt(j);
            }
        }
        return slow;
    }
}
