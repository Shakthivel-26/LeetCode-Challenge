class Solution {
    public int bestClosingTime(String customers) {
        char[] a = customers.toCharArray();
        int minpen=0, curpen=0, early =0;
        for(int i=0 ; i<a.length; i++){
            if(a[i]=='Y') curpen--;
            else curpen++;
            if(curpen < minpen){
                early = i+1;
                minpen = curpen;
            }
        }
        return early;
    }
}
