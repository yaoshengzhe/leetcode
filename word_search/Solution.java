public class Solution {
    private static class Result {
        public boolean found = false; 
    }
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                visited[i][j] = false;
            }
        }
        Result result = new Result();
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                dfs(board, word, i, j, result, "", visited);
                if (result.found) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isOnBoard(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;    
    }
    
    private void dfs(char[][] board, String word, int x, int y,
                     Result result, String path, boolean[][] visited) {
        if (!result.found && isOnBoard(board, x, y) && !visited[x][y]) {
            visited[x][y] = true;
            String w = path + board[x][y];
            if (word.equals(w)) {
                result.found = true;
            } else if (word.startsWith(w)) {
                dfs(board, word, x-1, y, result, w, visited);
                dfs(board, word, x+1, y, result, w, visited);
                dfs(board, word, x, y-1, result, w, visited);
                dfs(board, word, x, y+1, result, w, visited);
            }
            visited[x][y] = false;
        }
    }
}