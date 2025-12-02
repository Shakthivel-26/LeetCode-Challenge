class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> count = new HashMap<>();
        final long MOD = 1_000_000_007L;
        for (int[] p : points) {
            count.put(p[1], count.getOrDefault(p[1], 0L) + 1);
        }
        long sum = 0;
        long ans = 0;
        for (long c : count.values()) {
            long edge = c * (c - 1) / 2;
            ans = (ans + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }
        return (int) ans;
    }
}
