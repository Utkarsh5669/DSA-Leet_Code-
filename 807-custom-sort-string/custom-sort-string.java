class Solution {
    public String customSortString(String order, String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder sortedString = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                int frequency = frequencyMap.get(c);
                while (frequency-- > 0) {
                    sortedString.append(c);
                }
                frequencyMap.remove(c);
            }
        }
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            while (frequency-- > 0) {
                sortedString.append(c);
            }
        }
        return sortedString.toString();
    }
}