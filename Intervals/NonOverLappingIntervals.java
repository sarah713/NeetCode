package Intervals;

import java.util.Arrays;

public class NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int cnt = intervals.length - 1;
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                cnt--;
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
