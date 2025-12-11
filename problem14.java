class Solution {
    public int findFinalValue(int[] nums, int original) {
        ArrayList<Integer> list =new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        while(list.contains(original)){
            original = 2*original;
        }
        return original;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.print(sol.findFinalValue(new int[]{5,3,6,1,12},3));
        System.out.print(sol.findFinalValue(new int[]{2,7,9},4));
    }
}
