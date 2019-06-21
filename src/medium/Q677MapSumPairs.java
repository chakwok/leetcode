package medium;

import java.util.TreeMap;

public class Q677MapSumPairs {
    TreeMap<String, Integer> map;

    /** Initialize your data structure here. */
    public Q677MapSumPairs() {
        map =  new TreeMap<String, Integer>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        String key = map.ceilingKey(prefix);
        while(key != null && key.startsWith(prefix)) {
            res += map.get(key);
            key = map.higherKey(key);
        }

        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */