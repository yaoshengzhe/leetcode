public class Solution {
    public String strStr(String str, String pattern) {
        if (str == null || pattern == null) {
            return null;
        } else if (pattern.length() == 0) {
            return str;
        }

        int[] prefix = computePrefix(pattern);
        int j = 0;
        for (int i=0; i < str.length(); ++i) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = prefix[j-1];
            }

            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == pattern.length()) {
                return str.substring(i - j + 1);
            }
        }
        return null;
    }

    private int[] computePrefix(String pattern) {
        if (pattern.length() == 0) {
            return new int[0];
        }
        int[] prefix = new int[pattern.length()];
        prefix[0] = 0;
        for (int i=1; i < pattern.length(); ++i) {
            int k = prefix[i-1];
            while (k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
                k = prefix[k-1];
            }
            if (pattern.charAt(i) == pattern.charAt(k)) {
                prefix[i] = k + 1;
            } else {
                prefix[i] = k;
            }
        }
        return prefix;
    }
}
