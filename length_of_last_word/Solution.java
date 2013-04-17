public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }    
        int wordStart = -1;
        int wordEnd = -1;
        for (int i=s.length()-1; i > -1; --i) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                if (wordStart == -1) {
                    wordStart = i;
                }
                wordEnd = i;
            } else if (ch == ' ' && wordStart != -1) {
                wordEnd = i+1;
                break;
            }
        }
        return (wordStart == -1) ? 0 : (wordStart - wordEnd + 1);
    }
}