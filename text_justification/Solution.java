public class Solution {

    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        int wordStart = 0;
        int curLineMinLen = words[0].length() + 1;
        for (int i=1; i < words.length; ++i) {
            if (curLineMinLen + words[i].length() > L) {
                int totalSpaces = i - wordStart + L - curLineMinLen;
                int pad = (i - wordStart) == 1 ? 1 : Math.max(1, totalSpaces / (i - wordStart - 1));
                result.add(justify(words, wordStart, i, pad, L, totalSpaces - pad * (i - wordStart - 1)));
                wordStart = i;
                curLineMinLen = 0;
            }
            curLineMinLen += (words[i].length() + 1);
        }

        if (wordStart < words.length) {
            result.add(justify(words, wordStart, words.length, 1, L, 0));
        }
        return result;
    }
    private String justify(String[] words, int start, int end, int pad, int L, int remaining) {
        StringBuilder buf = new StringBuilder(L);
        for (int i=start; i < end; ++i) {
            buf.append(words[i]);
            if (i != end - 1) {
                for (int j=0; j < pad; ++j) {
                    buf.append(' ');
                }
                if (remaining > 0) {
                    buf.append(' ');
                    remaining--;
                }
            }
        }
        for (int i=buf.length(); i < L; ++i) {
            buf.append(' ');
        }
        return buf.toString();
    }
}
