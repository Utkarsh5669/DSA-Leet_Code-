class Solution {
    public long minimumSteps(String s) {
        long count = 0;
        long zeroNum = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == '0'){
                zeroNum++;
            } else{
                count += zeroNum;
            }

        }
        return count;
    }
}