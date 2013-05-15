import java.lang.StringBuilder;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> buf = new ArrayList<String>();
        int len = 0;
        int i = 0;
        while (len <= L) {
            if (i == words.length) {
                result.add(justifyLeft(buf, L));
                break;
            }
            if (len == 0) {
                len += words[i].length();
                buf.add(words[i]);
                i++;
            } else if ((len + words[i].length() + 1) <= L) {
                len += (words[i].length() + 1);
                buf.add(words[i]);
                i++;
            } else {
                result.add(justify(buf, L));
                len = 0;
                buf.clear();
            }
        }
        
        return result;
    }
    
    private String justifyLeft(List<String> buf, int L) {
        StringBuilder builder = new StringBuilder();
        int len = 0;
        for (String s : buf) {
            builder.append(s);
            len += s.length();
            if (len < L) {
                builder.append(' ');
                len++;
            }
        }
        while (len < L) {
            builder.append(' ');
            len++;            
        }
        return builder.toString();
    }
    
    private String justify(List<String> buf, int L) {
        int len = 0;
        for (String s : buf) {
            len += s.length();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(buf.get(0));
        
        if (buf.size() == 1) {
            for (int i=0; i < (L - len); ++i) {
                builder.append(' ');
            }
            return builder.toString();
        }
        
        int numOfBlank = (L - len) / (buf.size() - 1);
        int unevenBlank = (L - len) - numOfBlank * (buf.size() - 1);
        for (int i=1; i < buf.size(); ++i) {
            for (int j=0; j < numOfBlank; ++j) {
                builder.append(' ');
            }
            if (unevenBlank > 0) {
                builder.append(' ');
                unevenBlank--;
            }
            builder.append(buf.get(i));
        }
        return builder.toString();
    }
}