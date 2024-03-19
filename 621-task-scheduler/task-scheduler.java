class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskFrequency = new HashMap<>();
        for (char task : tasks) {
            taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(taskFrequency.values());
        int intervals = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for (int freq : temp) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }
            intervals += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return intervals;
    }
}