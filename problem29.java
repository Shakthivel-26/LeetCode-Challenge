class Solution {
    static final long MOD = 1_000_000_007;
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 2];
        dp[0] = 1;
        pref[1] = 1;
        int left = 0;
        int currMin = nums[0];
        int currMax = nums[0];
        for (int right = 0; right < n; right++) {
            currMin = Math.min(currMin, nums[right]);
            currMax = Math.max(currMax, nums[right]);
            while (currMax - currMin > k) {
                left++;
                currMin = nums[left];
                currMax = nums[left];
                for (int i = left + 1; i <= right; i++) {
                    currMin = Math.min(currMin, nums[i]);
                    currMax = Math.max(currMax, nums[i]);
                }
            }
            dp[right + 1] = (pref[right + 1] - pref[left] + MOD) % MOD;
            pref[right + 2] = (pref[right + 1] + dp[right + 1]) % MOD;
        }
        return (int) dp[n];
    }
}
