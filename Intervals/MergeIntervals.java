package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (end <= interval[0]) {
                end = Math.max(interval[1], end);
            } else {
                res.add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[] { start, end });

        return res.toArray(new int[0][]);
    }
}
