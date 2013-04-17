public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] uniqPath = new int[row][col];
        int val = 1;
        for (int i=0; i < row; ++i) {
            if (obstacleGrid[i][0] == 1) {
                val = 0;
            }
            uniqPath[i][0] = val;
        }
        val = 1;
        for (int i=0; i < col; ++i) {
            if (obstacleGrid[0][i] == 1) {
                val = 0;
            }
            uniqPath[0][i] = val;
        }
        for (int i=1; i < row; ++i) {
            for (int j=1; j < col; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    uniqPath[i][j] = 0;
                } else {
                    uniqPath[i][j] = uniqPath[i-1][j] + uniqPath[i][j-1];
                }
            }
        }
        return uniqPath[row-1][col-1];
    }
}