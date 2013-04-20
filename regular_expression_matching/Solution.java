public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }
    
    private boolean isMatchHelper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        
        if (j+1 < p.length() && p.charAt(j+1) == '*') {
            while (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                if (isMatchHelper(s, p, i, j+2)) {
                    return true;
                } else {
                    i++;
                }
            }
            return isMatchHelper(s, p, i, j+2);
        } else if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            return isMatchHelper(s, p, i+1, j+1);
        } else {
            return false;
        }
    }
}