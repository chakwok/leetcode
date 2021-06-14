package medium

fun findBall(grid: Array<IntArray>): IntArray {
    val cachedCellToLastCell = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()


    val out = IntArray(grid[0].size) {0}
    for(col in 0 until grid[0].size) {
        val path = mutableListOf<Pair<Int, Int>>()

        var curr = Pair(col, 0) //x, y
        val lastCell :Pair<Int, Int>
        while(true) {
            if(cachedCellToLastCell.containsKey(curr)) {
                lastCell = cachedCellToLastCell[curr]!!
                break
            }

            path.add(curr)
            val nextCell = nextCell(grid, curr)

            if(nextCell == curr) {
                lastCell = curr
                break;
            } /*else if(nextCell.second == grid.size - 1) {
                lastCell = nextCell
                break
            }*/ else {
                curr = nextCell
            }
        }

        val x = lastCell.first
        val y = lastCell.second
        out[col] = if(y == grid.size) { // reach the last+1 row
             x
        } else -1

        path.forEach {
            cachedCellToLastCell[it] = lastCell
        }
    }

    return out
}

fun nextCell(grid: Array<IntArray>, curr: Pair<Int, Int>): Pair<Int, Int> {
    val x = curr.first
    val y = curr.second

    if(y == grid.size) { // reach the last+1 row
        return curr
    }

    val dir = grid[y][x]

    return if(dir == 1) { // either stuck in the middle of rows or go down
        if(x >= grid[0].size-1 || grid[y][x+1] == -1) {
            curr
        } else {
            Pair(x+1, y+1)
        }
    } else {
        if(x <= 0 || grid[y][x-1] == 1) {
            curr
        } else {
            Pair(x-1, y+1)
        }
    }
}

fun main(){
    findBall(arrayOf(
        intArrayOf(1,1,1,-1,-1),
        intArrayOf(1,1,1,-1,-1),
        intArrayOf(-1,-1,-1,1,1),
        intArrayOf(1,1,1,1,-1),
        intArrayOf(-1,-1,-1,-1,-1),
    )).also { println(it.joinToString(",")) }

    findBall(arrayOf(intArrayOf(-1))).also { println(it.joinToString(",")) }
    findBall(arrayOf(
        intArrayOf(1,1,1,1,1,1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(1,1,1,1,1,1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
    )).also { println(it.joinToString(",")) }
}