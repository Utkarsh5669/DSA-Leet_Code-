class Solution {
    public int pivotInteger(int n) {
            long totalSum = (long) n * (n + 1) / 2; 

        long leftSum = 0;
        for (int x = 1; x <= n; x++) {
            long rightSum = totalSum - leftSum - x;
            if (leftSum == rightSum) {
                return x;
            }
            leftSum += x;
        }
        return -1; 
    }
      
}