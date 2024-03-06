class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s==null||s.length()==0)
           return 0;

           int maxlength=0;
           int left=0;
       Map<Character, Integer> charIndexMap = new HashMap<>();
       for(int i=0;i<s.length();i++){
           char ch= s.charAt(i);
           if(charIndexMap.containsKey(ch)){
           left = Math.max(left,charIndexMap.get(ch)+1);
           }
           charIndexMap.put(ch,i);
           maxlength= Math.max(maxlength, i-left+1);
       }
       return maxlength;
    }
}