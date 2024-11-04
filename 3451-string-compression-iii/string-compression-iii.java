class Solution {
    public String compressedString(String word) {
        StringBuilder s = new StringBuilder();
        int c=1;
        int n = word.length();
        int i=1;
        while(i<n)
        {
            if(c==9|| word.charAt(i)!=word.charAt(i-1)){
                s.append(c).append(word.charAt(i-1));
                c=1;
                i++;
                continue;
            }
            if(word.charAt(i)==word.charAt(i-1)){
                c++;
            }
            i++;
        }
        return s.append(c).append(word.charAt(n-1)).toString();
    }
}