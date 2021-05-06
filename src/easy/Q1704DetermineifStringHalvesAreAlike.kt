package easy

fun halvesAreAlike(s: String): Boolean {
    val a  = s.substring(0 until (s.length/2))
    val b = s.substring(s.length/2)

    val match = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val getCount = { it: Char -> it in match }
    return a.count(getCount) == b.count(getCount)
}