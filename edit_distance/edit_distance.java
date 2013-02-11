/**
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

/*
T[i][j] = min {T[i][j-1] + 1, T[i-1][j] + 1, T[i-1][j-1] + 1?}
*/

import java.lang.Math;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int[][] table = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i <= word2.length(); ++i) {
            table[0][i] = i;
        }
        for (int i=1; i <= word1.length(); ++i) {
            table[i][0] = i;
        }

        for (int i=1; i <= word1.length(); ++i) {
            for (int j=1; j <= word2.length(); ++j) {
                int diff = (word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 1;
                table[i][j] = Math.min(table[i][j-1] + 1,
                                       Math.min(table[i-1][j] + 1, table[i-1][j-1] + diff));
             }
        }
        return table[word1.length()][word2.length()];
    }
}
