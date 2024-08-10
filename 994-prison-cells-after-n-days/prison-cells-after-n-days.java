

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        boolean hasCycle = false;
        int cycleLength = 0;
        
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String stateKey = Arrays.toString(next);
            
            if (seen.containsKey(stateKey)) {
                hasCycle = true;
                cycleLength = i - seen.get(stateKey);
                break;
            } else {
                seen.put(stateKey, i);
            }
            
            cells = next;
        }
        
        if (hasCycle) {
            N %= cycleLength;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] newCells = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            newCells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return newCells;
    }
}
