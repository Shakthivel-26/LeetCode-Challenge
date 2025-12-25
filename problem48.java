import java.util.*;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum=0;
        int turns=0;
        Integer[] happy = new Integer[happiness.length];
        for(int i=0; i<happiness.length; i++) happy[i] = happiness[i];
        Arrays.sort(happy, Collections.reverseOrder());
        for(int i=0; i<k; i++){
            sum += Math.max(happy[i]-turns, 0); 
            turns++;
        }
        return sum;
    }
}
