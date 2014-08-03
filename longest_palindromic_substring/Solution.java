public class Solution {
    public String longestPalindrome(String s) {
        char[] modifiedStr = new char[s.length() * 2 + 1];
        for (int i=0; i < s.length(); ++i) {
            modifiedStr[2*i] = '#';
            modifiedStr[2*i+1] = s.charAt(i);
        }
        modifiedStr[s.length()*2] = '#';
        int[] p = new int[s.length()*2 + 1];
        int center = 0;
        int right = 0;
        p[0] = 0;
        int bestCenter = 0;

        for (int i=1; i < modifiedStr.length-1; ++i) {

            int mirror = 2 * center - i;

            if (right > i) {
                if (right - i > p[mirror]) {
                    p[i] = p[mirror];
                } else {
                    p[i] = right - i;
                }
            } else {
                p[i] = 0;
            }

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < modifiedStr.length &&
                   modifiedStr[i - p[i] - 1] == modifiedStr[i + p[i] + 1]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                right = i + p[i];
                center = i;
            }

            if (p[bestCenter] < p[i]) {
                bestCenter = i;
            }
        }
        return s.substring((bestCenter - p[bestCenter])/2, (bestCenter + p[bestCenter])/2);
    }
}
