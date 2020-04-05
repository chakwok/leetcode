package easy

class Q1351CountNegativeNumbersinaSortedMatrix {
    fun countNegatives(grid: Array<IntArray>): Int {
        var count = 0
        for(arr in grid) {
            for(i in arr.size - 1 downTo 0) {
                if(arr[i] < 0) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}