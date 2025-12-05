class Solution {
    public int countPartitions(int[] nums) {
        int total = 0, a = nums.length;
        for(int i=0;i<a;i++){
            total += nums[i];
        }
        if(total%2==0){
            return a-1;
        }else{
            return 0;
        }
    }
}
