package hard;

import java.util.ArrayList;
import java.util.Collections;

public class Q295FindMedianfromDataStream {
    ArrayList<Integer> lst;

    /** initialize your data structure here. */
    public Q295FindMedianfromDataStream() {
        lst = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        if(lst.size() == 0) {
            lst.add(num);
        } else {
            int pos = Collections.binarySearch(lst, num);
            if(pos < 0) {
                pos = -(pos + 1);
            }
            lst.add(pos, num);
        }
    }

    public double findMedian() {
        int rPos = lst.size()/2;
        if(lst.size()%2 == 0) {
            return (lst.get(rPos) + lst.get(rPos - 1)) / 2.0;
        } else {
            return (double)lst.get(rPos);
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
