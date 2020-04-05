package easy

import kotlin.math.pow

class Q1323Maximum69Number {
    fun maximum69Number (num: Int): Int {
        var aNum = num;
        var idxLast6 = -1;

        var idx = 0;
        while(aNum > 0) {
            val curr = aNum%10;
            if(curr == 6) {
                idxLast6 = idx;
            }

            idx++;
            aNum /= 10;
        }

        return num + 3 * 10.0.pow(idxLast6).toInt();
    }
}