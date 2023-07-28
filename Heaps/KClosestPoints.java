package Heaps;

import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Double.compare(
                Math.sqrt(Math.pow(a[0] - 0, 2) + Math.pow(a[1] - 0, 2)),
                Math.sqrt(Math.pow(b[0] - 0, 2) + Math.pow(b[1] - 0, 2))));

        for (int[] point : points) {
            heap.offer(point);
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}
