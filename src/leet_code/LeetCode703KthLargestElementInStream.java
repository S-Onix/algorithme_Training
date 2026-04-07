package src.leet_code;

import java.util.PriorityQueue;

public class LeetCode703KthLargestElementInStream {

    PriorityQueue<Integer> heap;
    int k;
    public LeetCode703KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for(int num : nums) add(num);
    }

    public int add(int val) {
        heap.offer(val);
        if( heap.size() > k ) {
            heap.poll();
        }

        return heap.peek();
    }
}
