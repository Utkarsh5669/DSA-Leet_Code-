class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int x, y;
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }
        int count = 0;
        for (int[] guard : guards) {
            x = guard[0] - 1;
            y = guard[1];
            while (x >= 0 && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    count++;
                    grid[x][y] = -1;
                }
                x--;
            }
            x = guard[0] + 1;
            while (x < m && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    count++;
                    grid[x][y] = -1;
                }
                x++;
            }
            x = guard[0];
            y = guard[1] - 1;
            while (y >= 0 && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    count++;
                    grid[x][y] = -1;
                }
                y--;
            }
            y = guard[1] + 1;
            while (y < n && grid[x][y] != 1) {
                if (grid[x][y] != -1) {
                    count++;
                    grid[x][y] = -1;
                }
                y++;
            }
        }
        return m * n - guards.length - walls.length - count;
    }
}