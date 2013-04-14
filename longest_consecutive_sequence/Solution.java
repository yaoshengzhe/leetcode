import java.util.HashMap;
import java.lang.Math;

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0; 
        }   
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i : num) {
            if (!map.containsKey(i)) {
                map.put(i, i);
                if (map.containsKey(i-1)) {
                    int lower = map.get(i-1);
                    map.put(lower, i);
                    map.put(i, lower);
                    max = Math.max(max, i - lower + 1);
                }
                
                if (map.containsKey(i+1)) {
                    int lower = map.get(i);
                    int upper = map.get(i+1);
                    map.put(lower, upper);
                    map.put(upper, lower);
                    max = Math.max(max, upper - lower + 1);
                }
            }
        }
        return max;
    }
}