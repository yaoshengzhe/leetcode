public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i=0; i < board.length; ++i) {
            int row = 0;
            for (int j=0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (isset(row, digit)) {
                        return false;
                    }
                    row = setbit(row, digit);
                }
            }
        }

        for (int j=0; j < board[0].length; ++j) {
            int col = 0;
            for (int i=0; i < board.length; ++i) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (isset(col, digit)) {
                        return false;
                    }
                    col = setbit(col, digit);
                }
            }
        }

        for (int cube=0; cube < 9; ++cube) {
            int c = 0;
            for (int x=0; x < 3; ++x) {
                int i = (cube / 3) * 3 + x;
                for (int y=0; y < 3; ++y) {
                    int j = (cube % 3) * 3 + y;
                    if (board[i][j] != '.') {
                        int digit = board[i][j] - '0';
                        if (isset(c, digit)) {
                            return false;
                        }
                        c = setbit(c, digit);
                    }
                }
            }
        }
        return true;
    }

    private boolean isset(int num, int i) {
        return ((1 << i) & num) != 0;
    }

    private int setbit(int num, int i) {
        return (1 << i) | num;
    }
}
