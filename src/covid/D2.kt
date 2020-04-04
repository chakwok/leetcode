package covid

class D2 {
    fun isHappy(n: Int): Boolean {
        val repeated = HashSet<Int>();
        var curr = n;
        var sum = 0;
        while(sum != 1) {
            while(curr != 0) {
                val remainder = curr%10;
                sum += remainder * remainder
                curr /= 10;
            }
            if(sum == 1){
                return true;
            } else if(sum in repeated) {
                return false;
            } else {
                repeated.add(sum);
            }
            curr = sum;
            sum = 0;
        }
        return true;
    }
}