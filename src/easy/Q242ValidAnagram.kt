package easy

class Q242ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        return tohashedString(s) == tohashedString(t)
    }

    private fun tohashedString(str: String): String {
        val arr = IntArray(26);
        for(char in str) {
            arr[char - 'a']++
        }
        return arr.joinToString(":")
    }

    fun isAnagramMuchFaster(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val counter = IntArray(26)
        for (i in 0 until s.length) {
            counter[s[i] - 'a']++
            counter[t[i] - 'a']--
        }
        for (count in counter) {
            if (count != 0) {
                return false
            }
        }
        return true
    }
}