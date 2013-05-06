import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    private static class Pair {
        public String word;
        public int cost;
        public Pair(String word, int cost) {
            this.word = word;
            this.cost = cost;
        }
    }
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(start, 1));
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            if (distance(node.word, end) == 1) {
                return node.cost + 1;
            }
            for (String word : generateWords(node.word)) {
                if (dict.contains(word) && !visited.contains(word) && distance(node.word, word) == 1) {
                    queue.offer(new Pair(word, node.cost + 1));
                    visited.add(word);
                }
            }
        }
        return 0;
    }
    
    private List<String> generateWords(String word) {
        List<String> words = new ArrayList<String>();
        char[] buf = word.toCharArray();
        for (int i=0; i < buf.length; ++i) {
            char tmp = buf[i];
            for (int j=0; j < 26; ++j) {
                buf[i] = (char)('a' + j);
                words.add(new String(buf));
            }
            buf[i] = tmp;
        }
        return words;
    }
    
    private int distance(String a, String b) {
        int dist = 0;
        for (int i=0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}