package easy

class Q1342NumberofStepstoReduceaNumbertoZero {
    fun numberOfSteps (num: Int): Int {
        var count = 0;
        var aNum = num;
        while(aNum != 0) {
            if(aNum and 1 == 0) {
                aNum shr 1;
            } else {
                aNum -= 1;
            }
            count++;
        }
        return count;
    }

    fun numberOfStepsBF (num: Int): Int {
        var count = 0;
        var aNum = num;
        while(aNum != 0) {
            if(aNum %2 == 0) {
                aNum/=2
            } else {
                aNum-=1
            }
            count++;
        }
        return count;
    }


}