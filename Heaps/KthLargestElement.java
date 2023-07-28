package Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int i : nums) {
            heap.offer(i);
        }

        int f = k - 1;
        while (f > 0) {
            heap.poll();
            f--;
        }
        return heap.poll();
    }
}
