package easy

import java.lang.IllegalStateException

private val mapping = mapOf(
    Pair('I', 1),
    Pair('V', 5),
    Pair('X', 10),
    Pair('L', 50),
    Pair('C', 100),
    Pair('D', 500),
    Pair('M', 1000)
)

fun romanToInt(romanianExp: String): Int {
    var sum = 0

    var prev: Char? = null

    for(i in romanianExp.indices) {
        val curr = romanianExp[i]
        if(prev != null) {
            val increasingSig = (mapping[curr]!! - mapping[prev]!!) > 0

            if(increasingSig) {
                sum += helper("$prev$curr")
                prev = null
            } else {
                sum += helper(prev.toString())
                prev = curr
            }
        } else {
            prev = curr
        }
    }

    if(prev != null) {
        sum += helper(prev.toString())
    }

    return sum
}

private fun helper(romanianShortExp: String): Int {
    return when(romanianShortExp.length) {
        1 -> mapping[romanianShortExp[0]]!!
        2 -> {
            mapping[romanianShortExp[1]]!! - mapping[romanianShortExp[0]]!!
        }
        else -> {
            throw IllegalStateException("should not eval romans with string greater than 2")
        }
    }
}



fun main() {
    romanToInt("III").also { println(it) }
}