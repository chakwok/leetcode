package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// skiplist
/*class MedianFinder {
    AtomicInteger id = new AtomicInteger();
    ConcurrentSkipListSet<int[]> skipList;

    public MedianFinder() {
        skipList = new ConcurrentSkipListSet<>(Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));
    }

    public void addNum(int num) {
        skipList.add(new int[]{num, id.getAndAdd(1)});
    }

    public double findMedian() {
        if(skipList.size()%2 == 1) {
            return skipList.
        }
    }
}*/

/*
    constaint:
    all values in min should be larger than max
    min should have equal/one element more than max
 */
/*
["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);


        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());
    }
 */
class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>(Comparator.naturalOrder());
        max = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        min.add(num);
        if(min.size() - max.size() == 2) {
            max.add(min.poll());
        } else if(max.size() > 0 && min.peek() < max.peek()) {
            min.add(max.poll());
            max.add(min.poll());
        }
    }

    public double findMedian() {
        if(min.size() > max.size()) {
            return min.peek();
        } else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
}

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
            lst.add(pos, num); // this could be O(n)
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
