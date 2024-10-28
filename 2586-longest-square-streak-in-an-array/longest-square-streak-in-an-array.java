import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums) {
            set.add((long) num);
        }

        int maxStreak = 0;
        for (int num : nums) {
            int count = 0;
            long current = num;
            while (set.contains(current)) {
                count++;
                current = current * current;
                if (current > Integer.MAX_VALUE) break; // Avoid overflow
            }
            maxStreak = Math.max(maxStreak, count);
        }

        return maxStreak >= 2 ? maxStreak : -1;
    }
}