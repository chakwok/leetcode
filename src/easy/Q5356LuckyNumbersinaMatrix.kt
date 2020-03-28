package easy

class Q5356LuckyNumbersinaMatrix {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val res = arrayListOf<Int>();
        for(row in matrix) {
            var min = Int.MAX_VALUE;
            var minIdx = -1;
            for(idx in row.indices) {
                var num = row[idx]
                if(num < min) {
                    min = num;
                    minIdx = idx;
                }
            }
            if(isMaxInCol(matrix, minIdx, min)) {
                res.add(min);
            }

        }
        return res;
    }

    private fun isMaxInCol(matrix: Array<IntArray>, col: Int, num: Int): Boolean {
        var max = Int.MIN_VALUE;
        var maxIdx = -1;
        for(idx in matrix.indices) {
            var tNum = matrix[idx][col];
            if(tNum > max) {
                max = tNum;
                maxIdx = idx;
            }
        }
        return num == max;
    }
}

fun main() {
    println(Q5356LuckyNumbersinaMatrix().luckyNumbers((arrayOf(intArrayOf(1,10,4,2), intArrayOf(9,3,8,7), intArrayOf(15,16,17,12)))))
}