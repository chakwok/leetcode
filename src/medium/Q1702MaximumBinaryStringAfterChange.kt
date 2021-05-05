package medium

fun main() {
    println(maximumBinaryString("000110"))
    maximumBinaryString("01").also {println(it)}
    maximumBinaryString("01111001100000110010").also {println(it)}  // expected: "11111111110111111111"
}

fun maximumBinaryString(binary: String): String {
    val zeroCount = binary.count() { it == '0' }
    if(zeroCount <= 1) {
        return binary
    }

    val firstZero = binary.indexOf('0')
    val zeroPos = firstZero + (zeroCount - 1)

    var sb = StringBuilder("1".repeat(binary.length))
    sb[zeroPos] = '0'
    return sb.toString()
}

fun maximumBinaryStringWrong(binary: String): String {
    val sb = StringBuilder(binary)
    // wrong to first convert all 00 -> 10
    for(i in 0..(sb.length - 2)) {
        val curr = sb[i]
        val next = sb[i + 1]
        if(curr == '0' && next == '0') {
            sb[i] = '1'
        }
    }

    var i = 0
    outer@ while(i < sb.length) {
        val curr = sb[i]
        if(curr == '0') {
            for(j in (i+1) until sb.length) {
                val next = sb[j]
                if(next == '0') {
                    sb[j] = '1'

                    sb[i] = '1'
                    sb[i+1] = '0'
                    i++;
                    continue@outer
                }
            }
            break;
        }

        i++
    }

    return sb.toString()
}

//00 -> 10, 10 -> 01
fun maximumBinaryStringOld(binary: String): String {
    val sb = StringBuilder(binary)

    for(i in 0..(sb.length - 2)) {
        val curr = sb[i]
        val next = sb[i + 1]
        if(curr == '0' && next == '0') {
            sb[i] = '1'
        }
    }

    var i = sb.length - 1
    outer@ while(i > 0) {
        val prev = sb[i - 1]
        val curr = sb[i]
        if(prev == '1' && curr == '0') {
            for(j in (i - 1) downTo 0) {
                if(sb[j] == '0') {
                    sb[i - 1] = '1'
                    sb[i] = '1'

                    sb[j] = '1'
                    sb[j + 1] = '0'
                    i = j + 1
                    continue@outer
                }
            }
            break;
        } else {
            i--
        }
    }

    return sb.toString()
}