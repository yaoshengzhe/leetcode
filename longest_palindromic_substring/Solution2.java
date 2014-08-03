/* @(#)Solution.java
 */
/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there 
 * exists one unique longest palindromic substring.
 *
 * @author Shengzhe Yao
 */

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = -1;
        int maxStart = -1;
        for (int i=0; i < s.length(); ++i) {
            int startOdd = getLongestPalindrome(s, i, i);
            int startEven = getLongestPalindrome(s, i-1, i);
            int oddLen = (i - startOdd) * 2 + 1;
            int evenLen = (i-startEven) * 2;
            if (oddLen > evenLen) {
                if (maxLen < oddLen) {
                    maxStart = startOdd;
                    maxLen = oddLen;
                }
            } else {
                if (maxLen < evenLen) {
                    maxStart= startEven;
                    maxLen = evenLen;
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    private int getLongestPalindrome(String s, int start, int end) {
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        return start+1;
    }
}
