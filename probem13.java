class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isOneBitCharacter(new int[]{1,0,0}));  
        System.out.println(sol.isOneBitCharacter(new int[]{1,1,1,0}));  
    }
}
