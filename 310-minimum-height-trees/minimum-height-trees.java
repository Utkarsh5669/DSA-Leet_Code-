public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();

        if (n == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.offer(i);
            }
        }

        while (n > 2) {
            int size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int u = leaves.poll();
                for (int v : adjList.get(u)) {
                    if (--indegree[v] == 1) {
                        leaves.offer(v);
                    }
                }
            }
        }

        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }
}