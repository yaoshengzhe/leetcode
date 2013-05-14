public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        boolean hasStar = false;
        int pj = 0;
        int si = 0;
        while (i < s.length()) {
            char a = s.charAt(i);
            char b = (j < p.length()) ? p.charAt(j) : 0;
            if (b == '?' || a == b) {
                i++;
                j++;
            } else if (b == '*') {
                hasStar = true;
                do {
                    j++;
                } while (j < p.length() && p.charAt(j) == '*');
                si = i;
                pj = j-1;
            } else {
                if (!hasStar) {
                    return false;
                }
                si++;
                i = si;
                j = pj+1;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}