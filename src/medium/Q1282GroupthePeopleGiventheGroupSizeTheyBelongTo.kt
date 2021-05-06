package medium

fun main() {
    groupThePeople(intArrayOf(3,3,3,3,3,1,3))
}

fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val map = mutableMapOf<Int, MutableSet<Int>>()  //size to id

    for(i in groupSizes.indices) {
        val groupSize = groupSizes[i]

        val set = map.getOrPut(groupSize) { mutableSetOf<Int>() }
        set.add(i)
    }

    val out = mutableListOf<List<Int>>()

    for(entry in map.entries) {
        val size = entry.key
        val members = entry.value

        val iter = members.iterator()
        var group = mutableListOf<Int>(iter.next())
        while(iter.hasNext()) {
            val member = iter.next()
            if(group.size < size) {
                group.add(member)
            } else {
                out.add(group)
                group = mutableListOf(member)
            }
        }
        out.add(group)
    }

    return out
}