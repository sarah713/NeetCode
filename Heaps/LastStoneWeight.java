package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            heap.offer(i);
        }
        int res = 0;
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if (x < y) {
                heap.offer(y - x);
            }

            else if (y < x) {
                heap.offer(x - y);
            }
        }
        if (heap.isEmpty())
            return 0;
        else
            return heap.poll();
    }
}
