public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        long result = 0;
        int pos = 0;
        while (pos < str.length() && str.charAt(pos) == ' ') {
            pos++;
        }
        int sgn = 1;
        if (pos < str.length()) {
            char ch = str.charAt(pos);
            if (ch == '-') {
                sgn = -1;
                pos++;
            } else if (ch == '+') {
                sgn = 1;
                pos++;
            }
        }
        while (pos < str.length()) {
            char ch = str.charAt(pos);
            if (ch < '0' || ch > '9') {
                break;
            }
            result = result * 10 + ch - '0';
            pos++;
        }
        result = sgn * result;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}