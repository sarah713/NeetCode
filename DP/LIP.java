package DP;

public class LIP {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 1 || col == 1)
            return 1;

        int max = 0;
        int[][] memo = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (memo[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, i, j, memo));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] > 0)
            return memo[i][j];

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        int ans = 1;
        for (int[] dir : dirs) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];

            if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length) {
                continue;
            }

            if (matrix[nextX][nextY] <= matrix[i][j]) {
                continue;
            }

            ans = Math.max(ans, 1 + dfs(matrix, nextX, nextY, memo));
        }
        memo[i][j] = ans;
        return ans;
    }
}
