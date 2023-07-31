package Graphs;

public class SurroundedRegions {
    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] != 'X') {
                dfs(i, 0, grid);
            }

            if (grid[i][n - 1] != 'X') {
                dfs(i, n - 1, grid);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (grid[0][i] != 'X') {
                dfs(0, i, grid);
            }

            if (grid[n - 1][i] != 'X') {
                dfs(n - 1, i, grid);
            }
        }
        swap(grid, 'O', 'X');
        swap(grid, 'p', 'O');
    }

    public void swap(char[][] grid, char p, char q) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == p)
                    grid[i][j] = q;
            }
        }
    }

    void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 'O') {
            return;
        }
        grid[i][j] = 'p';

        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }
}
