import java.util.HashSet;
import java.util.Set;

class Solution {
    // Main function to find the maximum number of unique substrings
    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();  // Set to store unique substrings
        int[] maxCount = {0};  // Array to store the maximum count of unique substrings
        
        // Call the backtracking function to find the maximum count
        backtrack(s, 0, seen, 0, maxCount);
        
        return maxCount[0];  // Return the final result
    }

    // Backtracking function to explore all possible splits
    private void backtrack(String s, int start, Set<String> seen,
                           int count, int[] maxCount) {
        // Pruning: If the remaining characters plus current count can't exceed maxCount, return
        if (count + (s.length() - start) <= maxCount[0]) return;

        // Base case: If we've reached the end of the string
        if (start == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);  // Update maxCount if necessary
            return;
        }

        // Try all possible substrings starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);  // Extract substring
            
            // If the substring is not in the set (i.e., it's unique)
            if (!seen.contains(substring)) {
                seen.add(substring);  // Add the substring to the set
                
                // Recursively call backtrack with updated parameters
                backtrack(s, end, seen, count + 1, maxCount);
                
                seen.remove(substring);  // Remove the substring from the set (backtracking)
            }
        }
    }
}