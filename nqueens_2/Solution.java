import java.lang.Math;

public class Solution {
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        for (int i=0; i < n; ++i) {
            queens[i] = -1;
        }
		int[] count = new int[1];
		count[0] = 0;
        solveNQueensHelper(queens, 0, n, count);
		return count[0];
    }

    private void solveNQueensHelper(int[] queens, int curRow, int n, int[] count) {
        if (curRow == n) {
			count[0]++;
            return;
        }
        for (int col=0; col < n; ++col) {
            queens[curRow] = col;
            if (isValid(queens, curRow, col)) {
                solveNQueensHelper(queens, curRow+1, n, count);
            }
        }
        queens[curRow] = -1;
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i=0; i < row; ++i) {
            if (queens[i] == col) {
                return false;
            }
        }
        for (int i=0; i < row; ++i) {
            if (Math.abs(col - queens[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
