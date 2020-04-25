package medium

class Q146LRUCache {
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
}