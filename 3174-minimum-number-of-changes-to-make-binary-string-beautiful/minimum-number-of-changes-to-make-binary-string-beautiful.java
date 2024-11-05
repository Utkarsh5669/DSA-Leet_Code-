class Solution {
    public int minChanges(String s) {
        int c=0;
        for(int i=1;i<s.length();i+=2){
            if(s.charAt(i-1)!=s.charAt(i)){
                c++;
            }
        }
        return c;
    }
}