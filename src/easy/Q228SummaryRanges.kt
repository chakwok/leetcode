package easy

class Q228SummaryRanges {

    fun summaryRanges(nums: IntArray): List<String> {
        val lst = mutableListOf<String>();
        if(nums.isEmpty()) {
            return lst;
        }

        var start: Int = nums[0];
        var prev :Int = nums[0];
//        var curr: Int;
        for(i in 1 until nums.size) {
            val curr = nums[i];
            if(curr == prev + 1) {   // continuous
                prev = curr;
            } else {    // broken; need to add
                if(start == prev) {
                    lst.add(prev.toString());
                } else {
                    lst.add("${start}->${prev}")
                }

                start = curr;
                prev = curr;
            }
        }

        val last = nums[nums.size - 1];
        if(last == start) {
            lst.add(last.toString())
        } else {
            lst.add("${start}->${last}")
        }

        return lst;
    }

}