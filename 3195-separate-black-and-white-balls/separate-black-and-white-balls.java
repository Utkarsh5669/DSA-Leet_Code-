class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        long zeroCnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i); 
            if (ch == '0') {
                zeroCnt++;
            } else if (ch == '1') {
                ans += zeroCnt;
            }
        }
        return ans;
    }
}