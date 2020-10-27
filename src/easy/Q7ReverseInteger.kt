package easy

import kotlin.math.abs

class Q7ReverseInteger {
    fun reverse(x: Int): Int {
        var xLocal = x;
        var sum = 0L;
        var iteration = 0;
        val isNegative = (xLocal < 0);
        if(isNegative) {
            xLocal = abs(xLocal)
        }

        while (xLocal > 0) {
            val remainder = xLocal % 10;
            xLocal /= 10

            sum *= 10;
            sum += remainder;
            if(sum > Integer.MAX_VALUE) {
                return 0;
            }
            iteration++;
        }
        if(isNegative) {
            sum *= -1;
        }
        return sum.toInt();
    }

}