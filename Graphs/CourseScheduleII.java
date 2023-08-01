package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] in = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int iter : adj.get(i)) {
                in[iter]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int i : adj.get(node)) {
                in[i]--;
                if (in[i] == 0)
                    q.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) {
            ans[ans.length - i - 1] = res.get(i);
        }

        if (res.size() != numCourses)
            return new int[0];

        return ans;
    }
}
