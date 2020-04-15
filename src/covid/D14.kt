package covid

import java.util.*

class D14 {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        val lst = LinkedList<Char>();
        s.forEach { lst.add(it) }

        for(sh in shift) {
            val amount = sh[1];
            if(amount > s.length) {
                continue;
            }

            when(sh[0]) {
                0 -> {
                    for(i in 0 until amount) {
                        lst.add(lst.removeFirst());
                    }
                }
                1 -> {
                    for(i in 0 until amount) {
                        lst.addFirst(lst.removeLast());
                    }
                }
            }
        }

        return lst.joinToString("");
    }
}

fun main() {
    println(D14().stringShift("abc", arrayOf(intArrayOf(0,1), intArrayOf(1,2))))
    println(D14().stringShift("abcdefg", arrayOf(intArrayOf(1,1), intArrayOf(1,1), intArrayOf(0,2), intArrayOf(1,3))))
}