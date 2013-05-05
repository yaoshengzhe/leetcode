import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            String key = toKey(s);
            ArrayList<String> words = map.get(key);
            if (words == null) {
                words = new ArrayList<String>();
                map.put(key, words);
            }
            words.add(s);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for (ArrayList<String> val : map.values()) {
            if (val.size() > 1) {
                result.addAll(val);
            }
        }
        return result;
    }
    
    private String toKey(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}