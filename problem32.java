class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int max = 100000;
        long[] rightFreq = new long[max + 1];
        long[] leftFreq = new long[max + 1];
        for (int x : nums) {
            rightFreq[x]++;
        }
        long ans = 0;
        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];
            rightFreq[mid]--;    
            int target = mid * 2;
            if (target <= max) {
                long left = leftFreq[target];
                long right = rightFreq[target];
                ans = (ans + left * right) % MOD;
            }
            leftFreq[mid]++;
        }
        return (int) ans;
    }
}
