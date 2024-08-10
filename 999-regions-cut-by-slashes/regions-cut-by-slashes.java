class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        int[] parent = new int[size];
        
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = row[j];
                if (c != '/') {
                    union(parent, index, index + 1);
                    union(parent, index + 2, index + 3);
                }
                if (c != '\\') {
                    union(parent, index, index + 3);
                    union(parent, index + 1, index + 2);
                }
                
                if (i > 0) {
                    union(parent, index, index - 4 * n + 2);
                }
                if (j > 0) {
                    union(parent, index + 3, index - 4 + 1);
                }
            }
        }

        int regions = 0;
        for (int i = 0; i < size; i++) {
            if (parent[i] == i) {
                regions++;
            }
        }

        return regions;
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
