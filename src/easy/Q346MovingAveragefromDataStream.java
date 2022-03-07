package easy;

import java.util.LinkedList;

public class Q346MovingAveragefromDataStream{
    class MovingAverage {
        int size;
        LinkedList<Integer> lst;
        double sum = 0L;
        public MovingAverage(int size) {
            this.size = size;
            lst = new LinkedList<>();
        }

        public double next(int val) {
            lst.add(val);
            sum += val;
            if(lst.size() > size) {
                sum -= lst.removeFirst();
            }
            return sum / lst.size();
        }
    }
}