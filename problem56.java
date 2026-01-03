class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;
        long dpA = 6;
        long dpB = 6;
        for (int i = 2; i <= n; i++) {
            long newA = (dpA * 2 + dpB * 2) % MOD;
            long newB = (dpA * 2 + dpB * 3) % MOD;
            dpA = newA;
            dpB = newB;
        }
        return (int)((dpA + dpB) % MOD);
    }
}
