package easy;

import java.util.ArrayList;

public class Q706DesignHashMap {
    private ArrayList<Integer> keys;
    private ArrayList<Integer> values;
    /** Initialize your data structure here. */
    public Q706DesignHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = keys.indexOf(key);
        if(index >= 0) {
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = keys.indexOf(key);
        return index < 0? -1 : values.get(index);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = keys.indexOf(key);
        if(index > 0) {
            keys.remove(index);
            values.remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */