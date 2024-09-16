class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Step 1: Convert all time points to minutes and store in a list
        List<Integer> vec = new ArrayList<>();
        for (String timePoint : timePoints) {
            int h = Integer.parseInt(timePoint.substring(0, 2));
            int m = Integer.parseInt(timePoint.substring(3));
            int mins = h * 60 + m;
            vec.add(mins);
        }
        
        // Step 2: Sort the time points
        Collections.sort(vec);
        
        // Step 3: Calculate the minimum difference
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < vec.size(); i++) {
            res = Math.min(vec.get(i) - vec.get(i - 1), res);
        }
        
        // Step 4: Handle the circular case (difference between the first and last time points)
        return Math.min(res, 1440 + vec.get(0) - vec.get(vec.size() - 1));
    }
}