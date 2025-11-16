class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long count = 0, streak = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                streak++;
            } else {
                count = (count + (streak * (streak + 1)) / 2) % mod;
                streak = 0;
            }
        }
        count = (count + (streak * (streak + 1)) / 2) % mod;
        return (int) count;
    }
}
