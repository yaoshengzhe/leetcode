import java.util.HashSet;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        HashSet<String> result = new HashSet<String>();
        dfs(s, 0, "", 0, result);
        return new ArrayList<String>(result);
    }
    
    private void dfs(String s, int start, String buf, int numOfDots, Set<String> result) {
        if (numOfDots == 3) {
            int val  = toInt(s.substring(start));
            if (val > -1) {
                result.add(buf + val);
            }
        } else if (numOfDots < 3) {
            if (start < s.length()) {
                dfs(s, start+1, buf + s.charAt(start) + ".", numOfDots+1, result);
            }
            if (start < s.length() - 1) {
                int val  = toInt(s.substring(start, start+2));
                if (val > -1) {
    			    dfs(s, start+2, buf + val + ".", numOfDots+1, result);
                }
            }
            if (start < s.length() - 2) {
                int val  = toInt(s.substring(start, start+3));
                if (val > -1) {
                    dfs(s, start+3, buf + val + ".", numOfDots+1, result);    
                }
            }
        }
    }
    
    private int toInt(String s) {
        int result = -1;
        int i = 0;
        if (s == null || s.length() == 0 || (s.length() > 1 && s.charAt(0) == '0')) {
            return -1;
        }
        
        String str = s.substring(i);
        try{
        int val = Integer.parseInt(str);
        if (val >= 0 && val <= 255) {
            result = val;
        }
        } catch (Exception e){}
        return result;
    }
}