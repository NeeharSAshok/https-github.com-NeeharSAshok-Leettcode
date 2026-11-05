class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: if we have matched all characters in the word
        if (index == word.length()) {
            return true;
        }
        
        // Boundary checks and character match check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Temporarily mark the current cell as visited by mutating it
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Explore all 4 directions (down, up, right, left)
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
        
        // Restore the cell value during backtracking
        board[i][j] = temp;
        
        return found;
    }
}