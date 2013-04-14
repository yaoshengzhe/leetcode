import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    private static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        for (int i=0; i < board.length; ++i) {
            visit(board, i, 0);
            visit(board, i, board[0].length-1);
        }
        
        for (int j=0; j < board[0].length; ++j) {
            visit(board, 0, j);
            visit(board, board.length-1, j);
        }
        
        for (int i=0; i < board.length; ++i) {
            for (int j=0; j < board[0].length; ++j) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void visit(char[][] board, int i, int j) {
        Queue<Pair> queue = new LinkedList<Pair>();
        Pair p = new Pair(i, j);
        while (p != null) {
            if (p.x < 0 || p.x >= board.length || p.y < 0 
                || p.y >= board[0].length || board[p.x][p.y] != 'O') {
                    p = queue.poll();
            } else {
                board[p.x][p.y] = 'T';
                queue.offer(new Pair(p.x-1, p.y));
                queue.offer(new Pair(p.x+1, p.y));
                queue.offer(new Pair(p.x, p.y-1));
                queue.offer(new Pair(p.x, p.y+1));
            }
        }
    }
}