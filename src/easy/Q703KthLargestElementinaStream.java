package easy;

import java.util.PriorityQueue;

public class Q703KthLargestElementinaStream{
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>(k);
            this.k = k ;
            for(int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();

            }
            return pq.peek();
        }
    }
}