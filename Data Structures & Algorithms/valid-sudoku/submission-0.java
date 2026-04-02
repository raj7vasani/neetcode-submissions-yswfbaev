class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            HashSet<Character> rows = new HashSet<>();
            for (char num : row){
                if (num == '.') {
                    continue;
                }
                if (rows.contains(num)) {
                    return false;
                } else {
                    rows.add(num);
                }
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            HashSet<Character> cols = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (cols.contains(board[row][col])) {
                    return false;
                } else {
                    cols.add(board[row][col]);
                }
            }
        }

        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (seen.contains(board[row][col])) {
                        return false;
                    } else {
                        seen.add(board[row][col]);
                    }
                }
            }
        }

        return true;

    }
}
