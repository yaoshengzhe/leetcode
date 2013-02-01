/**
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

import java.lang.Math;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] indexTable = new int[26];
        for (int i=0; i < indexTable.length; ++i) {
            indexTable[i] = -1;
        }
        int start = 0;
        int current = 0;
        while (current < s.length()) {
            int ch = s.charAt(current) - 'a';
            if (indexTable[ch] >= start) {
                maxLen = Math.max(maxLen, current - start);
                start = indexTable[ch] + 1;
            }
            indexTable[ch] = current;
            ++current;
        }
        return Math.max(maxLen, s.length() - start);
    }
}
