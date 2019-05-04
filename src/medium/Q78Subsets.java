package medium;

import java.util.*;

public class Q78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> toReturn = new LinkedList<>();

        LinkedList<Integer> first = new LinkedList<>();
        first.add(nums[0]);
        toReturn.add(first);

        for(int i = 1; i < nums.length; i++) {
            LinkedList<Integer> subset = new LinkedList<>();
            subset.add(nums[i]);

            ListIterator<List<Integer>> iterator = toReturn.listIterator();
            while(iterator.hasNext()) {
                //swallow copy is done here; but it doesn't matter
                @SuppressWarnings("unchecked")
                LinkedList<Integer> newSubset = (LinkedList<Integer>) subset.clone();
                newSubset.addAll(iterator.next());
                iterator.add(newSubset);
            }
            toReturn.add(subset);
        }

        toReturn.add(Collections.emptyList());
        return toReturn;
    }
}
