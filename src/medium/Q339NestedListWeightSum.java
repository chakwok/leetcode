package medium;

public class Q339NestedListWeightSum{
    /*
    public int depthSum(List<NestedInteger> nestedList) {
        return evaluateNestedInteger(nestedList, 1);
    }

    private int evaluateNestedInteger(List<NestedInteger> nestedList, int depth) {
        int out = 0;
        for(NestedInteger nested: nestedList) {
            if(nested.isInteger()) {
                out += nested.getInteger() * depth;
            } else {
                out += evaluateNestedInteger(nested.getList(), depth + 1);
            }
        }
        return out;
    }

    }*/
}