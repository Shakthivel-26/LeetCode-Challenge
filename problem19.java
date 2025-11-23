class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int min1 = Integer.MAX_VALUE, min11 = Integer.MAX_VALUE; // two smallest mod1
        int min2 = Integer.MAX_VALUE, min22 = Integer.MAX_VALUE; // two smallest mod2
        for (int x : nums) {
            sum += x;
            int r = x % 3;
            if (r == 1) {
                if (x < min1) { min11 = min1; min1 = x; }
                else if (x < min11) min11 = x;
            } 
            else if (r == 2) {
                if (x < min2) { min22 = min2; min2 = x; }
                else if (x < min22) min22 = x;
            }
        }
        int rem = sum % 3;
        if (rem == 0) return sum;
        int ans = 0;
        if (rem == 1) {
            int remove1 = min1;
            int remove2 = (min2 == Integer.MAX_VALUE || min22 == Integer.MAX_VALUE)
                          ? Integer.MAX_VALUE : min2 + min22;
            ans = sum - Math.min(remove1, remove2);
        } 
        else { // rem == 2
            int remove1 = min2;
            int remove2 = (min1 == Integer.MAX_VALUE || min11 == Integer.MAX_VALUE)
                          ? Integer.MAX_VALUE : min1 + min11;
            ans = sum - Math.min(remove1, remove2);
        }
        return ans < 0 ? 0 : ans;
    }
}
