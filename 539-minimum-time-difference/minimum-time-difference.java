class Solution {
    public int findMinDifference(List<String> tp) {
        int mini = Integer.MAX_VALUE;
        List<Integer> minutes = new ArrayList<>();

        // Convert each time point to minutes
        for (String val : tp) {
            int hr = 10 * (val.charAt(0) - '0') + (val.charAt(1) - '0'); // Extract hours
            int min = 10 * (val.charAt(3) - '0') + (val.charAt(4) - '0'); // Extract minutes
            minutes.add(hr * 60 + min); // Convert to total minutes
        }

        // Sort the minutes
        Collections.sort(minutes);

        // Calculate the minimum difference between adjacent times
        for (int i = 1; i < minutes.size(); i++) {
            mini = Math.min(mini, minutes.get(i) - minutes.get(i - 1));
        }

        // Also, check the difference between the first and last time, considering the 24-hour wraparound
        int n = minutes.size();
        mini = Math.min(mini, 1440 - (minutes.get(n - 1) - minutes.get(0)));

        return mini;
    }
}