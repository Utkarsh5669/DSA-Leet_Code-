class Solution {
    public boolean canSortArray(int[] nums) {
        boolean alreadyInc=true;
        int[] arr=new int[101];
        int n=nums.length;


        int prevMax=0;
        int prevBit=Integer.bitCount(nums[0]);        
        int currMin=Integer.MAX_VALUE;
        int currMax=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int bitCount=Integer.bitCount(nums[i]);
            if(prevBit==bitCount){              
                currMin=Math.min(currMin, nums[i]);
                currMax=Math.max(currMax, nums[i]);
            }
            else{               
                if(prevMax>currMin){
                    return false;
                }
                prevMax=currMax;   

                currMin=Integer.MAX_VALUE;
                currMax=Integer.MIN_VALUE; 
                currMin=Math.min(currMin, nums[i]);
                currMax=Math.max(currMax, nums[i]);             
            }
            prevBit=bitCount;
        }

        if(prevMax>currMin){
            return false;
        }


        return true;
    }
}