package Heaps;

import java.util.PriorityQueue;

public class KthLargestEle {
    int k;
    int[] nums;
    PriorityQueue<Integer> heap;

    public KthLargestEle(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        heap = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
