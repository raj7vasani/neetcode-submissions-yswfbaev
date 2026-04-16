class Solution {
    private int ROWS, COLS;
    Set<Pair<Integer, Integer>> seen = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || board[i][j] != word.charAt(idx) || 
            seen.contains(new Pair<>(i, j))) {
            return false;
        }

        seen.add(new Pair<>(i, j));
        boolean res = dfs(board, word, i + 1, j, idx + 1) || 
                      dfs(board, word, i - 1, j, idx + 1) ||
                      dfs(board, word, i, j + 1, idx + 1) ||
                      dfs(board, word, i, j - 1, idx + 1);
        seen.remove(new Pair<>(i, j));

        return res;
    }
}
