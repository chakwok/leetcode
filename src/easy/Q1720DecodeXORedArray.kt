package easy

fun decode(encoded: IntArray, first: Int): IntArray {
    val out = IntArray(encoded.size + 1)
    var idx = 0
    out[idx++] = first

    for(i in encoded.indices) {
        out[idx++] = encoded[i] xor out[i]
    }

    return out
}