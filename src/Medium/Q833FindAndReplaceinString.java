package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q833FindAndReplaceinString {
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
        String ans = findReplaceString("ukdaxmobyfnelsdeecwisaxwjjfrxwsyfibbvnenesupbifdza", new int[]{22,27,0,25,6,32,30,36,44,8,46,40,38,14,17,20}, new String[]{"xwj","rxw","uk","jf","ob","fib","sy","vn","bi","yfnel","fdza","esu","en","de","cw","sa"}, new String[]{"pw","lqpq","vp","w","ey","lavl","o","wvb","kpj","aosdke","ybie","kuh","a","b","j","gz"});
        System.out.println(ans);
    }
}

