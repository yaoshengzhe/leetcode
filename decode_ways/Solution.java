public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        // a = T(i-2), b = T(i-1), c = T(i)
        int a = 1;
        int b = 0;
        if (s.charAt(0) != '0' && s.charAt(1) != '0') {
            b = 1;
        }
        int val = Integer.parseInt(s.substring(0,2));
        
        if (val > 0 && val < 27) {
            b++;
        }
        
        for (int i=2; i < s.length(); ++i) {
            char cur = s.charAt(i);
            char prev = s.charAt(i-1);
            int c = 0;
            if (cur >= '1' && cur <= '9') {
                c = b;
            } 
            if ((prev == '1' && cur <= '9') || (prev == '2' && cur <= '6')) {
                c += a;
            }
            if (cur == '0' && (prev == '1' || prev == '2')) {
                c = a;                
            } 
            
            a = b;
            b = c;
        }
        return b;
    }
}