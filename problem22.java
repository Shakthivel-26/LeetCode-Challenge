class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;
        int[][] dp = new int[n][k];
        dp[0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            int[][] newRow = new int[n][k];
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                for (int r = 0; r < k; r++) {
                    if (j > 0) {
                        int nr = (r + val) % k;
                        newRow[j][nr] = (newRow[j][nr] + newRow[j-1][r]) % MOD;
                    }
                    if (i > 0) {
                        int nr = (r + val) % k;
                        newRow[j][nr] = (newRow[j][nr] + dp[j][r]) % MOD;
                    }
                }
                if (i == 0 && j == 0)
                    newRow[0][grid[0][0] % k] = 1;
            }
            dp = newRow;
        }
        return dp[n - 1][0];
    }
}
