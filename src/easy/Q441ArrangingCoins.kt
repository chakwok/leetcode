package easy


import kotlin.math.floor
import kotlin.math.sqrt


//O(1), quadratic equation
fun arrangeCoins(n: Int): Int {
    return floor((-1 + sqrt(1.0+ 4.0 * 2 * n))/2).toInt();
}

fun arrangeCoinsON(n: Int): Int {
    var curr = n;
    var out = 0 ;

    var lvl = 1;
    while(true) {
        if(curr >= lvl) {
            curr -= lvl;
            lvl++
            out++;
        } else {
            break;
        }
    }
    return out;
}

fun main() {
    arrangeCoins(0).also{println(it)}
    arrangeCoins(1).also{println(it)}
    arrangeCoins(2).also{println(it)}
    arrangeCoins(3).also{println(it)}
    arrangeCoins(5).also{println(it)}
    arrangeCoins(28).also{println(it)}
}