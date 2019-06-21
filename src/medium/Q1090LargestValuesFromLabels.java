package medium;

import helper.TreeNode;

import java.util.*;

public class Q1090LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < values.length; i++) {
            if(map.containsKey(labels[i])) {
                List<Integer> lst = map.get(labels[i]);
                lst.add(values[i]);
            } else {
                List<Integer> lst = new LinkedList<>();
                lst.add(values[i]);
                map.put(labels[i], lst);
            }
        }

        Map.Entry<Integer, List<Integer>> entry = map.firstEntry();
        int result = 0;

        while(entry != null && num_wanted != 0) {
            List<Integer> lst = entry.getValue();
            if(lst.size() > 1) {
                lst.sort(Collections.reverseOrder());
            }
            for(int i = 0; i < use_limit && i < lst.size(); i++) {
                result += lst.get(i);
                num_wanted--;
            }

            entry = map.ceilingEntry(entry.getKey());
        }

        return result;

    }

}
