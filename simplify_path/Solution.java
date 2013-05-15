import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new ArrayDeque<String>();
        for (String s : path.split("/")) {
            if (s.length() > 0) {
                if (s.equals("..")) {
                    if (!queue.isEmpty()) {
                        queue.removeLast();
                    }
                } else if (s.equals(".")) {
                    continue;
                } else {
                    queue.addLast(s);
                }
            }
        }
        StringBuilder buf = new StringBuilder();
        while (!queue.isEmpty()) {
            buf.append('/');
            buf.append(queue.pollFirst());
        }
        return buf.length() > 0 ? buf.toString() : "/";
    }
}