package easy

fun main() {
    maximumUnits(arrayOf(intArrayOf(1,3), intArrayOf(3,1),  intArrayOf(2,2)),4 ).also {println(it)}
}

fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    if(truckSize == 0) {
        return 0
    }

    boxTypes.sortByDescending { it[1] }
    var availableSpace = truckSize
    var unitTaken = 0
    for(boxType in boxTypes) {
        val numBox = boxType[0]
        val numUnit = boxType[1]

        if(availableSpace >= numBox) {
            availableSpace -= numBox
            unitTaken += numBox * numUnit
        } else if(availableSpace < numBox) {
            unitTaken += availableSpace * numUnit
            break
        }


    }

    return unitTaken
}