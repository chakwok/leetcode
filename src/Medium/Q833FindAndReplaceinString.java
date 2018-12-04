package Medium;

import java.util.*;

public class Q833FindAndReplaceinString {
    //an O (n) runtime solution (c.f. to nlgn. It's faster as the sorting step is eliminated by
    public static String findReplaceStringSol(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }


    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes.length == 0) {
            return S;
        }

        // create an index of array that store the ascending order of indexes,
        // so that the order can be accessed from an increasing order
        List<Integer> indexOrder = new ArrayList<>(indexes.length);

        for (int i = 0; i < indexes.length; i++) {
            indexOrder.add(i);
        }

        Collections.sort(indexOrder, Comparator.comparing((Integer s) -> indexes[indexOrder.indexOf(s)]));

        int netChanges = 0;
        StringBuilder result = new StringBuilder(S);


        for (Integer order: indexOrder) {
            int start = indexes[order] + netChanges;
            if (result.substring(start, start + sources[order].length()).equals(sources[order])) {
                result.replace(start, start + sources[order].length(), targets[order]);
                netChanges += targets[order].length() - sources[order].length();
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String ans = findReplaceStringSol("ukdaxmobyfnelsdeecwisaxwjjfrxwsyfibbvnenesupbifdza", new int[]{22,27,0,25,6,32,30,36,44,8,46,40,38,14,17,20}, new String[]{"xwj","rxw","uk","jf","ob","fib","sy","vn","bi","yfnel","fdza","esu","en","de","cw","sa"}, new String[]{"pw","lqpq","vp","w","ey","lavl","o","wvb","kpj","aosdke","ybie","kuh","a","b","j","gz"});
        System.out.println(ans);
    }
}

