public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
		if (nRows < 2) {
			return s;
		}
		
        char[] buf = new char[s.length()];
        int idx = 0;
        for (int i=0; i < nRows; ++i) {
            int k = i;
            do {
    			if (k < s.length()) {
                	buf[idx++] = s.charAt(k);
				}
                int mid = 2*nRows + k - 2 - 2 * i;
                if (mid > k && mid < (2*nRows-2+k) && mid < s.length()) {
                    buf[idx++] = s.charAt(mid);    
                }
				k = 2*nRows - 2 + k;
            } while (k < s.length());
        }
        return new String(buf);
    }
}