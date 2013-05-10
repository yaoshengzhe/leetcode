import java.lang.StringBuilder;

public class Solution {
    public String countAndSay(int n) {
        StringBuilder buf = new StringBuilder();
        buf.append('1');
        for (int i=1; i < n; ++i) {
            String s = buf.toString();
            buf = new StringBuilder();
            char prev = s.charAt(0);
            int freq = 1;
            for (int j=1; j < s.length(); ++j) {
                char ch = s.charAt(j);
                if (ch == prev) {
                    freq++;
                } else {
                    buf.append(freq);
                    buf.append(prev);
                    freq = 1;
                    prev = ch;
                }
            }
            if (freq > 0) {
                buf.append(freq);
                buf.append(prev);
            }
        }
        return buf.toString();
    }
}
