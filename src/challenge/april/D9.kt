package challenge.april

class D9 {
    fun backspaceCompare(S: String, T: String): Boolean {
        val sBSS = BackSpaceString(S);
        val tBSS = BackSpaceString(T);

        var sNext = sBSS.next();
        var tNext = tBSS.next();

        while(sNext != null || tNext != null) {
            if(sNext != tNext) {
                return false;
            }

            sNext = sBSS.next();
            tNext = tBSS.next();
        }

        return true;
    }

    private class BackSpaceString(val str: String) {
        var pos = str.length - 1;
        var skip = 0;

        fun next(): Char? {
            var res : Char? = null;

            while(pos >= 0) {
                if(str[pos] == '#') {
                    skip++;
                    pos--;
                } else {
                    if(skip > 0) {
                        skip--;
                        pos--;
                    } else {
                        res = str[pos];
                        pos--;
                        break;
                    }
                }
            }

            return res;
        }
    }


}

fun main() {
    println(D9().backspaceCompare("ab#c", "ad#c"))
    println(D9().backspaceCompare("a##c", "#a#c"))
    println(D9().backspaceCompare("a#c", "b"))
    println(D9().backspaceCompare("bwj##tw", "bwj###tw"))

}