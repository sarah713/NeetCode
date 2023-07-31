package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int total = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                if (grid[i][j] != 0) {
                    total++;
                }
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int rotten = 0, minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            rotten += size;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + dx[j];
                    int y = cur[1] + dy[j];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0
                            || grid[x][y] == 2) {
                        continue;
                    }

                    q.offer(new int[] { x, y });
                    grid[x][y] = 2;
                }
            }
            if (!q.isEmpty()) {
                minutes += 1;
            }
        }

        return total == rotten ? minutes : -1;

    }
}
