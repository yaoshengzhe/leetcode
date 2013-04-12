public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int N = s.length();
        int[] cut = new int[N];
        int[][] palindromeTable = new int[N][N];
        for (int i=0; i < N; ++i) {
            for (int j=0; j < N; ++j) {
                if (i == j) {
                    palindromeTable[i][j] = 1;
                } else {
                    palindromeTable[i][j] = -1;
                }
            }    
        }
        
        for (int i=0; i < N; ++i) {
            if (isPalindrome(s, 0, i, palindromeTable)) {
                cut[i] = 0;
            } else {
                int minCut = N;
                for (int k=0; k < i; ++k) {
                    if (isPalindrome(s, k+1, i, palindromeTable)) {
                        if (minCut > cut[k] + 1) {
                            minCut = cut[k] + 1;
                        }
                    }
                }
                cut[i] = minCut;
            }
        }
        return cut[N-1];
    }
    
    private boolean isPalindrome(String s, int start, int end, int[][] palindromeTable) {
        if (start >= end) {
            return true;
        }
        if (palindromeTable[start][end] != -1) {
            return palindromeTable[start][end] == 1;
        }
        if (s.charAt(start) != s.charAt(end)) {
            palindromeTable[start][end] = 0;
            return false;
        } else {
            boolean result = isPalindrome(s, start+1, end-1, palindromeTable);
            palindromeTable[start][end] = result ? 1 : 0;
            return result;
        }
    }
}