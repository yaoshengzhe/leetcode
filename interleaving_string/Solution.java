public class Solution {
    // T[i][j] = T[i-1][j] if s1[i] == s3[i+j]
    //           T[i][j-1] if s2[j] == s3[i+j]
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] table = new boolean[s1.length()+1][s2.length()+1];
        table[0][0] = true;
        for (int i=1; i < s2.length()+1; ++i) {
            table[0][i] = table[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i=1; i < s1.length()+1; ++i) {
            table[i][0] = table[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i=1; i < s1.length()+1; ++i) {
            for (int j=1; j < s2.length()+1; ++j) {
                table[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && table[i-1][j]) ||
                    (s2.charAt(j-1) == s3.charAt(i+j-1) && table[i][j-1]);
            }
        }
        return table[s1.length()][s2.length()];
    }
}
