class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        while(i<n && s.charAt(i)==' ') {
            i++;
        }
        if (i>=n) {
            return 0;
        }
        if (s.charAt(i)=='-') {
            sign = -1;
        }
        if (s.charAt(i)=='+' || s.charAt(i)=='-') {
            i++;
        }

        if (i>=n) {
            return 0;
        }
        int num = 0;
        while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9') {
            int x = s.charAt(i)-'0';
            if (num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && x>Integer.MAX_VALUE%10)) {
                if (sign==1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            num = num*10 + x;
            i++;
        }
        return num*sign;
    }
}