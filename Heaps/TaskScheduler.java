package Heaps;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int max = freq[freq.length - 1], cnt = 0;
        for (int i : freq) {
            if (i == max)
                cnt++;
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + cnt);
    }
}
