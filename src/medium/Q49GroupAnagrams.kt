package medium

import java.util.*

class Q49GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>();

        outer@ for(str in strs) {
            val arr =  IntArray(26) {0}
            for(char in str) {
                arr[char - 'a']++;
            }

            val key = arr.joinToString(":");
            val lst = map.getOrDefault(key, LinkedList<String>())
            lst.add(str);
            map[key] = lst;
        }

        return LinkedList(map.values);
    }

    //Time exceeds limit
    fun groupAnagramsSlow(strs: Array<String>): List<List<String>> {
        val res = LinkedList<MutableList<String>>();
        val paired = LinkedList<IntArray>();
        val lengths = LinkedList<Int>();

        outer@ for(str in strs) {
            val arr =  IntArray(26) {0}
            for(char in str) {
                arr[char - 'a']++;
            }
            for(i in paired.indices) {  // too expensive here
                if(lengths[i] != str.length) {
                    continue;
                }

                val pair = paired[i];
                if(arr.contentEquals(pair)) {
                    res[i].add(str);
                    continue@outer;
                }
            }


            val lst = LinkedList<String>();
            lst.add(str)
            res.add(lst);
            paired.add(arr);
            lengths.add(str.length)
        }


        return res;
    }
}