import java.lang.Math;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList();
        dfs(s, 0, "", 0, result);
        return result;
    }
    
    private void dfs(String s, int start, String buf, int numOfDots, List<String> result) {
        if (numOfDots == 3) {
            int val  = toInt(s.substring(start));
            if (val > -1) {
                result.add(buf + val);
            }
        } else if (numOfDots < 3) {
            for (int end=start+1; end <= Math.min(s.length(), start + 3); ++end) {
                int val = toInt(s.substring(start, end));
                if (val > -1) {
                    dfs(s, end, buf + val + ".", numOfDots+1, result);
                }
            }
        }
    }
    
    private int toInt(String s) {
        int result = -1;
        if (s == null || s.length() == 0 || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
            return -1;
        }
        int val = Integer.parseInt(s);
        if (val >= 0 && val <= 255) {
            result = val;
        }
        return result;
    }
}