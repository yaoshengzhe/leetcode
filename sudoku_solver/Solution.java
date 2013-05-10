public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i=0; i < 9; ++i) {
            for (int j=0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (int d=1; d < 10; ++d) {
                        board[i][j] = Character.forDigit(d, 10);
                        if (isValid(board, i, j) && solveSudokuHelper(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int col=0; col < 9; ++col) {
            if (col != j && board[i][col] == board[i][j]) {
                return false;
            }
        }

        for (int row=0; row < 9; ++row) {
            if (row != i && board[row][j] == board[i][j]) {
                return false;
            }
        }

        for (int x=(i/3) * 3; x < (i/3) * 3 + 3; ++x) {
            for (int y=(j/3) * 3; y < (j/3) * 3 + 3; ++y) {
                if (i != x && j != y && board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
