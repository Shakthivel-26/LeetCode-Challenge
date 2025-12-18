class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }
        int half = k / 2;
        long[] A = new long[n];
        long[] B = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = -(long) strategy[i] * prices[i];
            B[i] = (long) prices[i] - (long) strategy[i] * prices[i];
        }
        long[] preA = new long[n + 1];
        long[] preB = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preA[i + 1] = preA[i] + A[i];
            preB[i + 1] = preB[i] + B[i];
        }
        long maxGain = 0;
        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;
            long gain =
                (preA[mid] - preA[l]) +
                (preB[r] - preB[mid]);
            maxGain = Math.max(maxGain, gain);
        }
        return originalProfit + maxGain;
    }
}
