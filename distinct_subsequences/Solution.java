public class Solution {
    // A(i, j) = A(i-1, j) + S[i-1] == T[j-1] ? A(i-1, j-1) : 0
    public int numDistinct(String S, String T) {
        int[][] result = new int[S.length()+1][T.length()+1];
        for (int i=0; i < S.length() + 1; ++i) {
            result[i][0] = 1;
        }
        for (int i=1; i < T.length() + 1; ++i) {
            result[0][i] = 0;
        }
        for (int i=1; i < S.length() + 1; ++i) {
            for (int j=1; j < T.length() + 1; ++j) {
                result[i][j] = result[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    result[i][j] += result[i-1][j-1];
                }
            }
        }
        return result[S.length()][T.length()];
    }
}
