class Solution {
    public int maxFrequencyElements(int[] nums) {
//         int c=0;
//         int k=0;
//         int j=1;
//         int finalmax= 0;
//         int l= nums.length;
//         while(k<l-1){
//        for(int i= 0;i<nums.length;i++){
//           if(nums[k]==nums[j]){
//               c++;
//               j++;
//           }
//        }
//        if(c==0)
//        {
//            c++;
//        }
//        finalmax=finalmax+c;
//        k++;
//        c=0;
//        j=k+1;
//         }
//         return finalmax;
       HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int finalcount = 0;
        int maxFreq = Integer.MIN_VALUE;
        for (int frequency : mp.values()) {
            maxFreq = Math.max(maxFreq, frequency);
        }

        for (int frequency : mp.values()) {
            if (frequency == maxFreq)
                finalcount += maxFreq;
        }
        return finalcount;

}

}