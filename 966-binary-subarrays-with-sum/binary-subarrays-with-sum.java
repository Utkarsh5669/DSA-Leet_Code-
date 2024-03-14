class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}