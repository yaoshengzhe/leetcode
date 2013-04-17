public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean cleanLastRow = false;
        boolean cleanLastCol = false;
        
        for (int j=0; j < col; ++j) {
            if (matrix[row-1][j] == 0) {
                cleanLastRow = true;
                break;
            }
        }
        
        for (int i=0; i < row; ++i) {
            if (matrix[i][col-1] == 0) {
                cleanLastCol = true;
                break;
            }
        }
        for (int i=0; i < row-1; ++i) {
            for (int j=0; j < col-1; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[row-1][j] = 0;
                    matrix[i][col-1] = 0;
                }
            }
        }
    
        for (int i=0; i < row-1; ++i) {
            for (int j=0; j < col-1; ++j) {
                if (matrix[i][col-1] == 0 || matrix[row-1][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (cleanLastRow) {
            for (int j=0; j < col; ++j) {
                matrix[row-1][j] = 0;
            }
        }
        
        if (cleanLastCol) {
            for (int i=0; i < row; ++i) {
                matrix[i][col-1] = 0;
            }
        }
    }
}