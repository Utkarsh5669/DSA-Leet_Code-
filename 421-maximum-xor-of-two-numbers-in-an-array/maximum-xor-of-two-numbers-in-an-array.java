import java.util.*;
class Solution {
    public int findMaximumXOR(int[] nums) {
       int maxXor =0;
       int k=0;
       for(int i=31;i>=0;i--){
           k |= (1<<i);
           Set<Integer> pre = new HashSet<>();
           for(int num:nums){
               pre.add(num & k);
           }
           int temp = maxXor |(1<<i);
           for(int pr: pre){
               if(pre.contains(temp^pr)){
               maxXor = temp;
               break;
           }
       }
    }
        return maxXor;
    }
}
