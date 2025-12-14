class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        long ways = 1;
        int seatsSeen = 0;
        int plantsBetween = 0;
        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                seatsSeen++;
                if (seatsSeen % 2 == 0) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
            } else { 
                if (seatsSeen > 0 && seatsSeen % 2 == 0) {
                    plantsBetween++;
                }
            }
        }
        if (seatsSeen == 0 || seatsSeen % 2 != 0) {
            return 0;
        }
        return (int) ways;
    }
}
