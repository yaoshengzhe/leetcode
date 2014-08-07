public class Solution {

    // 1 2 -> 4 2 -> 3 1
    // 3 4    3 1    4 2

    // 1 2 3 -> 9 6 3 -> 7 4 1
    // 4 5 6    8 5 2    8 5 2
    // 7 8 9    7 4 1    9 6 3

    //    1  2  3  4
    //    5  6  7  8
    //    9  10 11 12
    //    13 14 15 16
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i=0; i < n; ++i) {
            for (int j=0; j < n - i - 1; ++j) {
                int tmp = matrix[i][j];
                //(i, n - i - 1)
                //(n - j - 1, j)
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tmp;
            }
        }

        for (int i=0; i < n/2; ++i) {
            for (int j=0; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
    }
}
