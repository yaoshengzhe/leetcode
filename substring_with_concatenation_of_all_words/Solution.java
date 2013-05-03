import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int wordLen = L[0].length();
        int substrLen = L.length * wordLen;
        for (int i=0; i < S.length() - substrLen + 1; ++i) {
            HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
            for (String w : L) {
                Integer freq = wordMap.get(w);
                if (freq == null) {
                    freq = 0;
                }
                wordMap.put(w, freq + 1);
            }

            for (int j=0; j < L.length; ++j) {
                int start = i + wordLen * j;
                String w = S.substring(start, start + wordLen);
                Integer freq = wordMap.get(w);
                if (freq == null) {
                    break;
                }
                if (freq == 1) {
                    wordMap.remove(w);
                } else {
                    wordMap.put(w, freq - 1);
                }
            }
            if (wordMap.isEmpty()) {
                result.add(i);
            }
        }
        return result;
    }
}
