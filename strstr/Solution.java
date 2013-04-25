public class Solution {
    public String strStr(String haystack, String needle) {
        for (int i=0; i < haystack.length() - needle.length() + 1; ++i) {
            int j = 0;
            for (; j < needle.length(); ++j) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}