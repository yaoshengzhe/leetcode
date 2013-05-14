import java.lang.Math;

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        int[] queens = new int[n];
        for (int i=0; i < n; ++i) {
            queens[i] = -1;
        }
        ArrayList<String[]> result = new ArrayList<String[]>();
        solveNQueensHelper(queens, 0, n, result);
        return result;
    }

    private void solveNQueensHelper(int[] queens, int curRow, int n, List<String[]> result) {
        if (curRow == n) {
            String[] sol = new String[n];
            char[] buf = new char[n];
            for (int i=0; i < n; ++i) {
                buf[i] = '.';
            }
            for (int i=0; i < n; ++i) {
                buf[queens[i]] = 'Q';
                sol[i] = new String(buf);
                buf[queens[i]] = '.';
            }
            result.add(sol);
            return;
        }
        for (int col=0; col < n; ++col) {
            queens[curRow] = col;
            if (isValid(queens, curRow, col)) {
                solveNQueensHelper(queens, curRow+1, n, result);
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
