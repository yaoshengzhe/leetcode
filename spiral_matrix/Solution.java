public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            helper(matrix, 0, 0, matrix.length, matrix[0].length, result);
        }
        return result;
    }

    void helper(int[][] matrix, int x, int y, int rowLen, int colLen, List<Integer> result) {
        if (rowLen <= 0 || colLen <= 0) {
            return;
        } else if (rowLen == 1) {
            for (int i=0; i < colLen; ++i) {
                result.add(matrix[x][y+i]);
            }
        } else if (colLen == 1) {
            for (int i=0; i < rowLen; ++i) {
                result.add(matrix[x+i][y]);
            }
        } else {
            for (int i=0; i < colLen; ++i) {
                result.add(matrix[x][y+i]);
            }

            for (int i=1; i < rowLen; ++i) {
                result.add(matrix[x + i][y+colLen-1]);
            }

            for (int i=1; i < colLen; ++i) {
                result.add(matrix[x + rowLen-1][y+colLen-1-i]);
            }

            for (int i=1; i < rowLen-1; ++i) {
                result.add(matrix[x + rowLen - 1 - i][y]);
            }
            helper(matrix, x+1, y+1, rowLen - 2, colLen - 2, result);
        }
    }
}
