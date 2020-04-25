package covid

class D24 {
    class LRUCache(capacity: Int) {
        private val map = object : LinkedHashMap<Int, Int>(capacity + 1, 0.75F, true) {
            override fun removeEldestEntry(eldest: Map.Entry<Int, Int>): Boolean {
                return this.size > capacity;
            }
        }


        fun get(key: Int): Int {
            return map[key]?: -1;
        }

        fun put(key: Int, value: Int) {
            map[key] = value;
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */
}