class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums)
            set.add((long) num);

        Arrays.sort(nums);
        int res = -1;

        for (int num : nums) {
            long temp = (long) num;
            int cnt = 1;
            while (set.contains(temp * temp)) {
                cnt++;
                temp = temp * temp;
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}