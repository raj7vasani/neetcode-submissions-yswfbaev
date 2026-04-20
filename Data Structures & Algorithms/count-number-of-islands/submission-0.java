class Solution {
    private int ROWS, COLS;
    Set<Pair<Integer, Integer>> seen = new HashSet<>();
    int count = 0;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1' && !seen.contains(new Pair(i, j))) {
                    dfs(grid, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS) {
            return;
        }

        if (grid[i][j] == '0' || seen.contains(new Pair<>(i, j))) {
            return;
        }

        seen.add(new Pair(i, j));
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
