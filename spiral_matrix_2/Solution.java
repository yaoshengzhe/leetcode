public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        helper(result, 0, 0, n, n, 1);
        return result;
    }

    void helper(int[][] matrix, int x, int y, int rowLen, int colLen, int currentNum) {
        if (rowLen <= 0 || colLen <= 0) {
            return;
        } else if (rowLen == 1) {
            for (int i=0; i < colLen; ++i) {
                matrix[x][y+i] = currentNum++;
            }
        } else if (colLen == 1) {
            for (int i=0; i < rowLen; ++i) {
                matrix[x+i][y] = currentNum++;
            }
        } else {
            for (int i=0; i < colLen; ++i) {
                matrix[x][y+i] = currentNum++;
            }

            for (int i=1; i < rowLen; ++i) {
                matrix[x + i][y+colLen-1] = currentNum++;
            }

            for (int i=1; i < colLen; ++i) {
                matrix[x + rowLen-1][y+colLen-1-i] = currentNum++;
            }

            for (int i=1; i < rowLen-1; ++i) {
                matrix[x + rowLen - 1 - i][y] = currentNum++;
            }
            helper(matrix, x+1, y+1, rowLen - 2, colLen - 2, currentNum);
        }
    }
}
