package easy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q1071GreatestCommonDivisorofStrings {
    //TODO: checkout this question again
    public String gcdOfStringsM1(String str1, String str2) {
        if (str1.length() < str2.length()) { return gcdOfStrings(str2, str1); } // make sure str1 is not shorter than str2.
        /*str1 is always longer than str1.   ABC ABCABC -> ABCABC ABC*/
        else if (!str1.startsWith(str2)) { return ""; } // shorter string is not common prefix.
        /* if the longer string does not start with shorter string. it's impossible to have common factors */
        else if (str2.isEmpty()) { return str1; } // gcd string found
        // .

        else { return gcdOfStrings(str1.substring(str2.length()), str2); } // cut off the common prefix part of str1.
    }
/*
* ABC ABCAB
* ABCAB ABC
* AB ABC
* ABC AB
* C AB
* AB C
* ""
*
*
*
*
* A AAAAA
* AAAAA A
* AAAA A
* AAA A
* AA A
* A A
* "" A
* A ""
* A
* */


    public static String gcdOfStrings(String str1, String str2) {
        List<String> lst1 = getFactors(str1);
        List<String> lst2 = getFactors(str2);

        lst1.sort((s1, s2) -> -(s1.length() - s2.length()));
        for(String str: lst1) {
            if(lst2.contains(str)) {
                return str;
            }
        }

        return "";
    }

    public static List<String> getFactors(String s) {
        List<String> lst = new LinkedList<>();
        lst.add(s);
        next:
        for(int i = 0; i < s.length()/2; i++) {
            if(s.length() %(i + 1) != 0) {
                continue;
            }

            String sub = s.substring(0, i + 1);
            for(int j = sub.length(); j < s.length(); j+= sub.length()) {
                if(s.indexOf(sub, j) != j) {
                    continue next;
                }
            }

            lst.add(sub);
        }
        return lst;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABC", "ABCABC"));
        System.out.println(gcdOfStrings("AB", "ABABAB"));
        System.out.println(gcdOfStrings("ABCd", "ABCABC"));
        System.out.println(gcdOfStrings("AAAAA", "AAAAA"));
    }
}
