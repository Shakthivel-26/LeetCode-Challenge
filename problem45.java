class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int rows = strs.length;
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++) {
            dp[i] = 1;
        }
        for (int i = cols - 2; i >= 0; i--) {
            for (int j = i + 1; j < cols; j++) {
                boolean valid = true;
                for (int r = 0; r < rows; r++) {
                    if (strs[r].charAt(i) > strs[r].charAt(j)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int maxKeep = 0;
        for (int x : dp) {
            maxKeep = Math.max(maxKeep, x);
        }
        return cols - maxKeep;
    }
}
