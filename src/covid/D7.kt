package covid

class D7 {
    fun countElements(arr: IntArray): Int {
        val counts = IntArray(1001) {0}
        for(num in arr) {
            counts[num]++;
        }

        var count = 0;
        for(i in 0..999) {
            if(counts[i + 1] > 0) {
                count += counts[i];
            }
        }

        return count;
    }
}