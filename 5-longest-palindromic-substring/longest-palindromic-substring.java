public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return ""; // edge case
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);   // Check for odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Check for even length palindrome
            int len = Math.max(len1, len2);   // Get the max length
            
            if (len > end - start) {    // If we found a longer palindrome
                start = i - (len - 1) / 2;    // Update the start index
                end = i + len / 2;    // Update the end index
            }
        }
        
        return s.substring(start, end + 1);  // Return the longest palindrome substring
    }
    
    // Expands around the center and returns the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;  // Return the length of the palindrome
    }
}