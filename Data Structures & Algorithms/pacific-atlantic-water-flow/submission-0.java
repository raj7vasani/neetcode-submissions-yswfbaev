class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<Pair<Integer, Integer>> pacific = new HashSet<>();
    Set<Pair<Integer, Integer>> atlantic = new HashSet<>();
    int ROWS, COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacific, heights, heights[0][c]);
            dfs(ROWS - 1, c, atlantic, heights, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacific, heights, heights[r][0]);
            dfs(r, COLS - 1, atlantic, heights, heights[r][COLS - 1]);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific.contains(new Pair(r, c)) && atlantic.contains(new Pair(r, c))) {
                    res.add(new ArrayList(List.of(r, c)));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, Set<Pair<Integer, Integer>> ocean, int[][] heights, int height) {
        if (ocean.contains(new Pair(i, j)) || i < 0 || j < 0 || i >= ROWS || j >= COLS || 
        heights[i][j] < height) {
            return;
        }
        
        ocean.add(new Pair(i, j));
        dfs(i + 1, j, ocean, heights, heights[i][j]);
        dfs(i - 1, j, ocean, heights, heights[i][j]);
        dfs(i, j + 1, ocean, heights, heights[i][j]);
        dfs(i, j - 1, ocean, heights, heights[i][j]);
    }
}
