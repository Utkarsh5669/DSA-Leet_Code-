import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<List<Integer>> obsSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obsSet.add(List.of(obs[0], obs[1]));
        }
        int[] directions = {0, 1, 2, 3}; // 0: north, 1: east, 2: south, 3: west
        int x = 0, y = 0, dir = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int newX = x + (dir == 1 ? 1 : dir == 3 ? -1 : 0);
                    int newY = y + (dir == 0 ? 1 : dir == 2 ? -1 : 0);
                    if (!obsSet.contains(List.of(newX, newY))) {
                        x = newX;
                        y = newY;
                    } else {
                        break;
                    }
                }
            }
            maxDist = Math.max(maxDist, x * x + y * y);
        }
        return maxDist;
    }
}