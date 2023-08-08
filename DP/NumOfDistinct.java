import java.util.Arrays;

public class NumOfDistinct {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countAllSub(m - 1, n - 1, s, t, dp);
    }

    int countAllSub(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = countAllSub(i - 1, j - 1, s, t, dp) + countAllSub(i - 1, j, s, t, dp);
            return dp[i][j];
        }
        dp[i][j] = countAllSub(i - 1, j, s, t, dp);
        return dp[i][j];
    }
}
