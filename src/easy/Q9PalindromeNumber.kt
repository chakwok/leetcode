package easy

class Q9PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if(x < 0) {
            return false;
        } else if(x in 1..9) {
            return true;
        }

        val str = x.toString().toCharArray();
        var lo = 0
        var hi = str.size - 1

        while (lo < hi) {
            if(str[lo] != str[hi]) {
                return false;
            }
            lo++;
            hi--;
        }

        return true;
    }
}